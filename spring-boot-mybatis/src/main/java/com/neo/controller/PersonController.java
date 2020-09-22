package com.neo.controller;

import com.neo.generator.dao.PersonMapper;
import com.neo.generator.entity.Person;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by xiaocai on 2020/9/22 17:40
 **/
@RestController
public class PersonController {
    @Autowired
    private PersonMapper personMapper;

    @RequestMapping("selectByPrimaryKey/{id}")
    public Person aa(@PathVariable int id){
        Person person = personMapper.selectByPrimaryKey(id);
        return person;
    }
}
