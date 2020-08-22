package com.neo.spring.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * create by xiaocai on 2020/8/21 16:39
 **/
public class Student implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {
    private String name;
    private ApplicationContext applicationContext;
    public Student() {
        System.out.println(this.getClass().getSimpleName()+"-----> "+"1 construct    通过构造器实例化bean");
    }

    public void setName(String name) {
        System.out.println(this.getClass().getSimpleName()+"-----> "+"2 setName()    设置对象属性");
        this.name = name;
    }

    @PostConstruct
    public void annotationPostConstruct(){
        System.out.println(this.getClass().getSimpleName()+"-----> "+"4 @PostConstruct    初始化方式：@PostConstruct");
    }

    @PreDestroy
    public void des(){
        System.out.println(this.getClass().getSimpleName()+"-----> "+"7 @PreDestroy    销毁方式：@PreDestroy");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(this.getClass().getSimpleName()+"-----> "+"3-1 BeanNameAware.setBeanName()    检查Aware相关接口，并设置相关依赖");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getSimpleName()+"-----> "+"5 InitializingBean.afterPropertiesSet()    初始化方式：InitializingBean.afterPropertiesSet()");
    }

    public void initMethod(){
        System.out.println(this.getClass().getSimpleName()+"-----> "+"6 initMethod()    初始化方式：自定义initMethod()");
    }

    public void destroyMethod(){
        System.out.println(this.getClass().getSimpleName()+"-----> "+"9 destroyMethod()    销毁方式：自定义destroyMethod()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getSimpleName()+"-----> "+"8 DisposableBean.destroy()    销毁方式：DisposableBean.destroy()");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(this.getClass().getSimpleName()+"-----> "+"3-2 BeanNameAware.setApplicationContext()    检查Aware相关接口，并设置相关依赖");
        this.applicationContext = applicationContext;
    }
}
