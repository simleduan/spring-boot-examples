package com.neo.other.jsontest;

import com.alibaba.fastjson.JSONObject;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * create by xiaocai on 2021/6/2 23:09
 **/
public class SchoolTest {
    public static void main(String[] args) {
        School school = new School();
        school.setSchoolName("清华大学");
        school.setXiaozhang("张三");

        Set<Integer> hashSet = new HashSet<>();
        for(int i=0;i<10;i++){
            hashSet.add(i);
        }

        school.setStudent(hashSet);


        String jsonString = JSONObject.toJSONString(school);
        System.out.println(jsonString);
        Map map = JSONObject.parseObject(jsonString, Map.class);
        Set set = map.keySet();
        for(Object setItem:set){
            System.out.println(setItem+"----"+map.get(setItem));
        }

        String setString = "[0,1,2,3,4,5,6,7,8,9]";
        Set setObject = JSONObject.parseObject(setString, Set.class);
        System.out.println(setObject);
        System.out.println(setObject.contains(2));
        System.out.println(setObject.contains("2"));
        System.out.println(setObject.contains("22"));
    }
}
