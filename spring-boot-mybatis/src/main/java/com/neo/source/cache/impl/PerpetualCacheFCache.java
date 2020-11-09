package com.neo.source.cache.impl;

import com.neo.source.cache.FCache;
import com.neo.source.cache.FCacheException;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 *  a {@link Configuration configuration} class that declares one or more
 * create by xiaocai on 2020/10/22 11:07
 * 为什么要重写hashCode和equals方法？
 *  因为在给hashMap存入自定义类时，首先会使用hashCode方法计算该类的哈西值，在没有复写hashCode和equals方法时，默认返回的是该对象内存地址
 *  {@link com.neo.source.cache.FCacheTest}
 * 首先来看下上文提到的integer的源码
 *    如Integer类中equals方法和hashcode方法均被重写，Integer类中的hashcode方法就是返回它本身的值，equals方法比较的是它本身的值是否相等。
 * 　　equals方法必须要满足以下几个特性
 * 　　1.自反性：x.equals(x) == true,自己和自己比较相等
 * 　　2.对称性：x.equals(y) == y.equals(x),两个对象调用equals的的结果应该一样
 * 　　3.传递性：如果x.equals(y) == true y.equals(z) == true 则 x.equals(z) == true,x和y相等，y和z相等，则x和z相等
 * 　　4.一致性 : 如果x对象和y对象有成员变量num1和num2，其中重写的equals方法只有num1参加了运算，则修改num2不影响x.equals(y)的值
 * 　　这时如果某个类没有重写hashcode方法的话，equals判断两个值相等，但是hashcode的值不相等，如String类，这样就会造成歧义
 *
 * Perpetual是"永久、不间断"之意，为什么这么命名呢？
 * 稍加联系，便能明白。缓存的设计有两个重点问题：
 * 如何存储数据和采用何种清除策略。
 * 存储的话，用哈希表即可完美解决。
 * 对于清除策略而言，往往有多种选择。
 * MyBatis作者Clinton Begin选择Perpetual来命名缓存，暗示这是一个最底层的缓存，
 * 数据一旦存储进来，永不清除，如果实现清除策略，请把Perpetual包装一下。
 * 在cache.decorators包里面有多种缓存，它们内部串联的主线就是按照“不同的清除策略”来贯穿的。
 **/
public class PerpetualCacheFCache implements FCache {

    public PerpetualCacheFCache(String id) {
        this.id = id;
    }

    private String id;
    private Map<Object,Object> cache = new HashMap<>();

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        cache.put(key,value);
    }

    @Override
    public Object getObject(Object key) {
        return cache.get(key);
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public Object removeObject(Object key) {
        return cache.remove(key);
    }

    @Override
    public int getSize() {
        return cache.size();
    }

    @Override
    public int hashCode() {
        if (this.getId() == null){
            throw new FCacheException("Cache instances require an Id,Please check your config!");
        }
        return this.getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getId() == null){
            throw new FCacheException("Cache instances require an Id,Please check your config!");
        }
        if (this == obj){
            return true;
        }
        if (!(obj instanceof FCache)){
            return false;
        }
        FCache otherCache = (FCache) obj;
        return this.getId().equals(otherCache.getId());
    }

}
