package com.neo;

import com.neo.model.User;
import com.neo.utils.RedisUtils;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @Author 樊斌
 * @Date 2020/8/11
 * @Version V1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @org.junit.Test
    public void test(){
        stringRedisTemplate.opsForValue().set("fanbin","樊斌");
        Assert.assertEquals("樊斌",stringRedisTemplate.opsForValue().get("fanbin"));
    }

    @org.junit.Test
    public void testOjb() throws InterruptedException {
        User user=new User("aa@126.com", "aa", "aa123456", "aa","123");
        ValueOperations<String,User> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("user",user);
        valueOperations.set("userDelete",user,1, TimeUnit.SECONDS);
        System.out.println(redisTemplate.hasKey("userDelete"));
        Thread.sleep(5000);
        System.out.println(redisTemplate.hasKey("userDelete"));
        System.out.println(redisUtils.getExpire("user"));
    }
}
