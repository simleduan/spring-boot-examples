package com.neo.moretest.annotationtest;import org.springframework.context.annotation.AnnotationConfigApplicationContext;public class FullAndLiteTest {    public static void main(String[] args) {        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FullConfig.class);        User bean = context.getBean(User.class);        System.out.println(bean.hashCode());        context.close();    }}