package com.neo.config;

import com.neo.aop.ExecuteAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
    @Bean
    public ExecuteAspect executeAspect(){
        return new ExecuteAspect();
    }
}
