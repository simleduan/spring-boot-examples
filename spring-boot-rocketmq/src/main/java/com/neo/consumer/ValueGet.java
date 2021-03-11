package com.neo.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * create by xiaocai on 2021/3/8 11:28
 **/
@Component
public class ValueGet {
    @Value("${lili.rocketmq.produce}")
    private String lili;

    @PostConstruct
    public void init(){
        System.out.println("----------------"+lili);
    }
}
