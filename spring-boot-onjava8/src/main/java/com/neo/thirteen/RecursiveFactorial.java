package com.neo.thirteen;/** * Created by cainiao on 2020-08-22 13:07 * 递归阶乘 */public class RecursiveFactorial {   static IntCall intCall;    public static void main(String[] args) {        intCall = n -> n==0?1:n*intCall.call(n-1);        for (int i=0;i<11;i++){            System.out.println(intCall.call(i));        }    }}