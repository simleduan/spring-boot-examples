package com.neo.thirteen;/** * Created by cainiao on 2020-08-22 12:46 * 知识点 1 * 知识点 2 * 知识点 3 * 知识点 4 * 知识点 5 * 知识点 6 */public class LambdaExpre {    interface Description{        String brief();    }    interface Body{        String detailed(String head);    }    interface Multi{        String twoArgs(String head,Double d);    }    static Body body = b->b +"No Parens";//知识点 1    static Body body2 = (b)->b +"More Parens";//知识点 2    static Description desc = ()->"Short info";//知识点 3    static Multi multi = (m,n)-> m+n;//知识点 4    static Description multiLines = ()->{//知识点 5        System.out.println("multiLines()");        return "this is multiLines";    };    public static void main(String[] args) {        System.out.println(body.detailed("Oh!"));        System.out.println(body2.detailed("Hi!"));        System.out.println(desc.brief());        System.out.println(multi.twoArgs("Pi! ", 3.14159));        System.out.println(multiLines.brief());    }}