package com.neo.config;

import com.neo.aop.ExecuteAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description: TODO
 * @Author 樊斌
 * @Date 2020/8/12
 * @Version V1.0
 **/
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
    @Bean
    public ExecuteAspect executeAspect(){
        return new ExecuteAspect();
    }
}
