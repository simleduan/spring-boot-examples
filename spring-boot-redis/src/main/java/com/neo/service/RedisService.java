package com.neo.service;import com.alibaba.fastjson.JSONObject;import com.neo.dao.UserInfoCrudRepository;import com.neo.model.UserInfo;import org.apache.commons.lang3.StringUtils;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.data.redis.core.StringRedisTemplate;import org.springframework.data.redis.core.script.DefaultRedisScript;import org.springframework.stereotype.Component;import java.util.Arrays;import java.util.Optional;import java.util.UUID;import java.util.concurrent.TimeUnit;/** * Created by cainiao on 2020-08-22 20:55 */@Componentpublic class RedisService {    @Autowired    private StringRedisTemplate stringRedisTemplate;    @Autowired    private UserInfoCrudRepository userInfoCrudRepository;    /**     * 1、解决缓存穿透：空结果缓存     * 2、解决缓存雪崩：key固定过期时间加一个随机值     * 3、解决缓存击穿：加锁     *     * 1、本地锁：synchronized     *  只要是同一把锁，就能锁住需要找个锁的所有线程     *  1.1 锁使用this，当前对象（本地锁，进程锁）     *      以为springboot项目中所有的组件在容器中都是单例的     *      缺点，分布式环境下是不行的。     *  现象:给查询数据库代码加本地锁后，在高并发情况下，发现还是会多次查询数据库。     *  问题原因:锁-时序问题，没有锁住。     *  解决方案:查询数据库和放入缓存操作要放在一个原子操作里。     * 2、分布式锁     *  本地锁在分布式环境下是不行的     *  分布式锁基于set nx命令操作     *  set nx 是原子操作     *  set not exist 就是不存在的时候，我才会给里面放     *     * @param id     * @return     */    public UserInfo getUserInfoById(String id) {        //首先通过id查询缓存        String userInfo = stringRedisTemplate.opsForValue().get(id);        if (!StringUtils.isEmpty(userInfo)){            System.out.println(id+" 已命中缓存，从redis里获取");            return JSONObject.parseObject(userInfo,UserInfo.class);        } else {            UserInfo dateBase = getDateBaseWithRedisLock(id);            return dateBase;        }    }    /**     * 本地锁     * @param id     * @return     */    private UserInfo getDateBaseWithLocalLock(String id) {        synchronized (this){            //拿到锁，再去缓存确认一次            String userInfo = stringRedisTemplate.opsForValue().get(id);            if (!StringUtils.isEmpty(userInfo)){                System.out.println(id+" 拿到锁，却命中缓存，从redis里获取");                return JSONObject.parseObject(userInfo,UserInfo.class);            }            System.out.println(id+" 拿到锁，却未命中缓存，从datebase里获取");            //查询数据库            Optional<UserInfo> userInfoDb = userInfoCrudRepository.findById(1l);            UserInfo userInfoDB = userInfoDb.get();            //放入缓存            System.out.println(id+" 获取完毕，放入缓存");            stringRedisTemplate.opsForValue().set(userInfoDB.getId().toString(),JSONObject.toJSONString(userInfoDB),1,TimeUnit.HOURS);            return userInfoDB;        }    }    /**     * @param id     * @return     */    private UserInfo getDateBaseWithRedisLock(String id) {        UserInfo userInfo;        //1、抢占分布式锁,去redis占坑//        Boolean lock = stringRedisTemplate.opsForValue().setIfAbsent("lock", "111");//在设置锁的时候，同时要设置锁的过期时间//        Boolean lock = stringRedisTemplate.opsForValue().setIfAbsent("lock", "111",300,TimeUnit.MINUTES);//在设置锁的时候，同时要设置锁的过期时间。为了避免在删除锁的时候，删除掉的是别人的锁，所以设置value为uuid，让每个锁的值都不一样        String uuid = UUID.randomUUID().toString();        Boolean lock = stringRedisTemplate.opsForValue().setIfAbsent("lock", uuid,300,TimeUnit.MINUTES);//在设置锁的时候，同时要设置锁的过期时间        if (lock){            System.out.println("获取分布式锁成功");            //设置锁的过期时间//            stringRedisTemplate.expire("lock",30,TimeUnit.MINUTES);            try{                userInfo = getDateBaseInfoAndSaveRedis(id);            }finally {                //删除锁，为了避免删除锁的时候，把别人的锁删掉，引入了uuid//            stringRedisTemplate.delete("lock");                //在删除锁的时候，首先去查一下是否是自己的锁，如果不是自己的锁，不要删除                //比较锁和删除锁要在同一个原子操作里完成//            String lockSelf = stringRedisTemplate.opsForValue().get("lock");//            if (uuid.equalsIgnoreCase(lockSelf)){//                stringRedisTemplate.delete("lock");//            }                //new DefaultRedisScript<Integer>(script,Integer.class)                //new DefaultRedisScript<Integer> 表示返回值的类型是Integer                //new DefaultRedisScript<Integer>(script,Integer.class)  (script,Integer.class)  脚本与返回值的类型                //如果redis通过key获取到的值与uuid的值相同就会删除该key                String script = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";                //删除锁                Long lock1 = stringRedisTemplate.execute(new DefaultRedisScript<Long>(script, Long.class), Arrays.asList("lock"), uuid);            }            return userInfo;        } else {            System.out.println("获取分布式锁失败，等待100毫秒，再去获取分布式锁，重试！");            try {                Thread.sleep(100);            } catch (InterruptedException e) {                e.printStackTrace();            }            //自旋方式            return getDateBaseWithRedisLock(id);        }    }    private UserInfo getDateBaseInfoAndSaveRedis(String id) {        String userInfo = stringRedisTemplate.opsForValue().get(id);        if (!StringUtils.isEmpty(userInfo)){            System.out.println(id+" 拿到锁，却命中缓存，从redis里获取");            return JSONObject.parseObject(userInfo,UserInfo.class);        }        Optional<UserInfo> userInfoDb = userInfoCrudRepository.findById(1l);        UserInfo userInfoDB = userInfoDb.get();        //放入缓存        System.out.println(id+" 获取完毕，放入缓存");        stringRedisTemplate.opsForValue().set(userInfoDB.getId().toString(),JSONObject.toJSONString(userInfoDB),1,TimeUnit.HOURS);        return userInfoDB;    }    /**     * @param id     * @return     */    private UserInfo getDateBaseWithRedisLockNoComment(String id) {        UserInfo userInfo;        String uuid = UUID.randomUUID().toString();        Boolean lock = stringRedisTemplate.opsForValue().setIfAbsent("lock", uuid,300,TimeUnit.MINUTES);//在设置锁的时候，同时要设置锁的过期时间        if (lock){            try{                userInfo = getDateBaseInfoAndSaveRedis(id);            }finally {                String script = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";                Integer lock1 = stringRedisTemplate.execute(new DefaultRedisScript<Integer>(script, Integer.class), Arrays.asList("lock"), uuid);            }            return userInfo;        } else {            System.out.println("加锁失败，等待100毫秒，再去获取分布式锁，重试！");            try {                Thread.sleep(100);            } catch (InterruptedException e) {                e.printStackTrace();            }            //自旋方式            return getDateBaseWithRedisLock(id);        }    }}