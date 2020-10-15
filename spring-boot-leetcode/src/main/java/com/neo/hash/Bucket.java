package com.neo.hash;

import java.util.LinkedList;

/**
 * create by xiaocai on 2020/10/12 14:12
 **/
public class Bucket {
    private LinkedList<Integer> container;

    public Bucket() {
        container = new LinkedList<>();
    }

    public void insert(Integer key){
        int index = container.indexOf(key);
        if (index == -1){
            container.addFirst(key);
        }
    }

    public void delete(Integer key){
        container.remove(key);
    }

    public boolean exist(Integer key){
        int index = container.indexOf(key);
        return index != -1;
    }

    @Override
    public String toString() {
        if (container.size()>0){
            return container.get(0).toString();
        }
        return "";
    }
}
