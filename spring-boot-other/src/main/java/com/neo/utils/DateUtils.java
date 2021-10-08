package com.neo.utils;

import java.text.SimpleDateFormat;

/**
 * create by xiaocai on 2021/5/11 16:22
 **/
public class DateUtils {

    public static void main(String[] args) {
        System.out.println(calcudate("20210511","20210611"));
        System.out.println(calcudate("20180314","20210512"));
    }

    public static String calcudate(String start,String end){
        String result="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try{
            long l = (sdf.parse(end).getTime() - sdf.parse(start).getTime()) / (24 * 60 * 60 * 1000);
            result = String.valueOf(l);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
}
