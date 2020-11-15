package com.neo.service;

public interface MailService {
    public void send(String to, String subject, String text);
}
