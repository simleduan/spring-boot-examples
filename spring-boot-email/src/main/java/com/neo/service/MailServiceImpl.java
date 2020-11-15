package com.neo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;

/**
 * create by xiaocai on 2020/11/11 17:23
 **/
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public void send(String to, String subject, String text) {
        Context context = new Context();
        context.setVariable("project", "demo");
        context.setVariable("author", "yimcarson");
        context.setVariable("code", text);
        String emailContent = templateEngine.process("mail", context);

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(to);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(emailContent, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        javaMailSender.send(message);
    }
}
