package com.neo.spring.beanlife;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * create by xiaocai on 2020/8/21 16:43
 **/
@Configuration
@Import(MyBeanPostPorcessor.class)
public class BeanLifeConfig {
    @Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
    public Student student(){
        Student student = new Student();
        student.setName("createName");
        return student;
    }
}
