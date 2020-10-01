package com.neo.generator;

import com.neo.generator.dao.PersonMapper;
import com.neo.generator.entity.Person;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * create by xiaocai on 2020/9/22 9:41
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    private PersonMapper personMapper;

    @org.junit.Test
    public void test(){
        Person person = new Person();
        person.setAge(11);
        person.setCreateTime(new Date());
        person.setGender("boy");
        person.setHometown("beijing");
        person.setName("王五");
        person.setPolicyNo("510988896");
        int insert = personMapper.insert(person);
        System.out.println(insert);
    }
}
