package com.neo.controller;

import com.neo.dao.UserInfoCrudRepository;
import com.neo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;


/**
 * @Description: TODO
 * @Author 樊斌
 * @Date 2020/8/12
 * @Version V1.0
 **/
@RestController
public class UserInfoCrudRepositoryController {

    @Autowired
    private UserInfoCrudRepository userInfoCrudRepository;

    @RequestMapping("save")
    public UserInfo addUserInfo(){
        UserInfo userInfo1 = new UserInfo("nickName", "email", "userName", "passWord", "regTime");
        UserInfo save = userInfoCrudRepository.save(userInfo1);
        return save;
    }

    @RequestMapping("count")
    public long count(){
        long count = userInfoCrudRepository.count();
        int i = 1 / 0;
        return count;
    }

    @RequestMapping("existsById/{id}")
    public boolean existsById(@PathVariable("id") long id) throws InterruptedException {
        boolean b = userInfoCrudRepository.existsById(id);
        return b;
    }

    @RequestMapping("findAll")
    public Iterator<UserInfo> findAll(){
        Iterable<UserInfo> all = userInfoCrudRepository.findAll();
        Iterator<UserInfo> iterator = all.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        return iterator;
    }
}
