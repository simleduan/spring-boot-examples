package com.neo.controller;

import com.neo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by xiaocai on 2020/11/11 17:47
 **/
@RestController
public class MailController {
    @Autowired
    private MailService mailService;

    @Value("${spring.mail.username}")
    private String emailAddr;

    @RequestMapping("/sendEmail")
    public void sendEmail(){
        mailService.send(emailAddr,"发送给QQ邮箱","文本内容，测试了");
    }
}
