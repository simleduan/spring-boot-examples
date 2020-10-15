package com.neo.generator.entity;

import java.io.Serializable;
import java.util.Date;

//存放在共享缓存中数据进行序列化操作和反序列化操作
//因此数据对应实体类必须实现【序列化接口】
public class Person implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private String gender;

    private String hometown;

    private Date createTime;

    private String policyNo;

    public Person(Integer id, String name, Integer age, String gender, String hometown, Date createTime, String policyNo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hometown = hometown;
        this.createTime = createTime;
        this.policyNo = policyNo;
    }

    public Person() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown == null ? null : hometown.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", hometown='" + hometown + '\'' +
                ", createTime=" + createTime +
                ", policyNo='" + policyNo + '\'' +
                '}';
    }

    public void setPolicyNo(String policyNo) {


        this.policyNo = policyNo == null ? null : policyNo.trim();
    }
}