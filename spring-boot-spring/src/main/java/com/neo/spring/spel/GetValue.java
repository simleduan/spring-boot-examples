package com.neo.spring.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * create by xiaocai on 2020/10/23 16:57
 **/
@Component
public class GetValue {
    @Value("#{spelBean['name']}")
    private String name;

    @Value("#{spelBean['desc']}")
    private String desc;

    @Value("#{systemProperties['user.language']}")
    private String userLanguage;

    @Value("#{systemProperties['user.country']}")
    private String desktop;

    public String getValue(){
        System.out.println("get value");
        return name+"--------"+desc+" language:"+userLanguage;
    }
}
