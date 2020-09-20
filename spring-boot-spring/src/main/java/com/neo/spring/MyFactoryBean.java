package com.neo.spring;import org.springframework.beans.factory.FactoryBean;/** * Created by cainiao on 2020-09-20 18:41 */public class MyFactoryBean implements FactoryBean<MyFactoryBean> {    private String name;    public String getName() {        return name;    }    public void setName(String name) {        this.name = name;    }    @Override    public MyFactoryBean getObject() throws Exception {        MyFactoryBean myFactoryBean = new MyFactoryBean();        myFactoryBean.setName("我在测试");        return myFactoryBean;    }    @Override    public Class<?> getObjectType() {        return this.getClass();    }    public static void main(String[] args) throws Exception {        MyFactoryBean myFactoryBean = new MyFactoryBean();        System.out.println(myFactoryBean.hashCode());        System.out.println(myFactoryBean.getName());        System.out.println(myFactoryBean.getObject().hashCode());        System.out.println(myFactoryBean.getObjectType());        System.out.println(myFactoryBean.getObjectType());        System.out.println(myFactoryBean.isSingleton());    }}