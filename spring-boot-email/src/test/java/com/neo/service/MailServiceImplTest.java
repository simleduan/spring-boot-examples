package com.neo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * create by xiaocai on 2020/11/11 17:32
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class MailServiceImplTest {
    @Autowired
    private MailService mailService;

    @Test
    public void test(){
        String emailAddr = "510988896@qq.com";
        mailService.send(emailAddr,"模板邮件", UUID.randomUUID().toString().toUpperCase());
        System.out.println("ok");
    }
}
