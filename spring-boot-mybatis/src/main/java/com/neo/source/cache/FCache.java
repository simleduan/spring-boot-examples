package com.neo.source.cache;

public interface FCache {
    //唯一id
    String getId();
    //存放缓存
    void putObject(Object key,Object value);
    //获取缓存
    Object getObject(Object key);
    //清空缓存
    void clear();
    //移除缓存
    Object removeObject(Object key);
    //缓存大小
    int getSize();
}
