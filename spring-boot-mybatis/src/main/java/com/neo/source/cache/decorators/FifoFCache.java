package com.neo.source.cache.decorators;

import com.neo.source.cache.FCache;

import java.util.Deque;
import java.util.LinkedList;

/**
 * create by xiaocai on 2020/10/22 14:46
 * 双向链表
 **/
public class FifoFCache implements FCache {
    private FCache deledge;
    private Deque<Object> keyList;
    private int size;

    public FifoFCache(FCache deledge, Deque<Object> keyList, int size) {
        this.deledge = deledge;
        this.keyList = new LinkedList<>();
        this.size = 1024;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String getId() {
        return deledge.getId();
    }

    @Override
    public void putObject(Object key, Object value) {
        cycleKeyList(key);
        deledge.putObject(key, value);
    }

    private void cycleKeyList(Object key) {
        keyList.addLast(key);
        if (keyList.size()>size){
            Object o = keyList.removeFirst();
            deledge.removeObject(o);
        }
    }

    @Override
    public Object getObject(Object key) {
        return deledge.getObject(key);
    }

    @Override
    public void clear() {
        deledge.clear();
        keyList.clear();
    }

    @Override
    public Object removeObject(Object key) {
        return deledge.removeObject(key);
    }

    @Override
    public int getSize() {
        return deledge.getSize();
    }
}
