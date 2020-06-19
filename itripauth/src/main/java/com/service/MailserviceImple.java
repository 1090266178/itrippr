package com.service;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MailserviceImple implements MailserviceInter{
    @Resource
    private SimpleMailMessage mailMessage;    //写邮件信息的类

    @Resource
    private MailSender mailSender;    //发送邮件的类

    @Override
    public void sendActiveationMail(String mailTo, String activeationCode) {
        mailMessage.setTo(mailTo);
        mailMessage.setText("您的激活码是:"+activeationCode);
        mailSender.send(mailMessage);
    }
}
