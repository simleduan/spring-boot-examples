package com.neo.impl;import com.alibaba.dubbo.config.annotation.Service;import com.neo.api.UserService;import com.neo.entity.User;import org.springframework.stereotype.Component;import java.util.Arrays;import java.util.List;/** * Created by cainiao on 2020-09-17 23:20 */@Component@Servicepublic class UserServiceImpl implements UserService {    @Override    public List<User> getUserlist() {        User zhangsan = new User("1", "zhangsan", "22");        User lisi = new User("2", "lisi", "33");        return Arrays.asList(zhangsan,lisi);    }}