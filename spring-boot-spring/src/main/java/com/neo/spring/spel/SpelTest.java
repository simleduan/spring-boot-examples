package com.neo.spring.spel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * create by xiaocai on 2020/10/23 16:45
 **/
public class SpelTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext((SpelConfig.class));
        GetValue bean = context.getBean(GetValue.class);
        String value = bean.getValue();
        System.out.println(value);
    }
}
