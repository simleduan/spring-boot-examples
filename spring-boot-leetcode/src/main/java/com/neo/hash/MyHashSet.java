package com.neo.hash;

import java.util.Arrays;

/**
 * create by xiaocai on 2020/10/12 14:22
 **/
public class MyHashSet {
    //桶数组，桶的容量
    private Bucket[] bucketArray;
    private int keyRange;
    private StringBuilder sb = new StringBuilder();

    public MyHashSet() {
        this.keyRange=769;
        this.bucketArray = new Bucket[keyRange];
        for (int i=0;i<keyRange;i++){
            bucketArray[i] = new Bucket();
        }
    }

    public int _hash(Integer key){
        return key%keyRange;
    }

    public void add(Integer key){
        int index = _hash(key);
        this.bucketArray[index].insert(key);
        sb.append("".equals(sb.toString())?key:","+key);
    }

    public void remove(Integer key){
        int index = _hash(key);
        this.bucketArray[index].delete(key);
    }

    public boolean contains(Integer key){
        int index = _hash(key);
        return this.bucketArray[index].exist(key);
    }

    @Override
    public String toString() {
        return "当前桶中数据为："+sb.toString();
    }
}
