package com.JavaMail;

import javax.mail.Message;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class JavaMailTool {
    /**
     * 发送邮件
     * @param account 发件人账号
     * @param password 发件人密码
     * @param receiveMailAccount 收件人账号
     * @throws Exception
     */
    public static void sendMessages(String account,String password,String receiveMailAccount) throws Exception {
        //1.使用properties对象封装连接所需信息
        Properties pro = new Properties();                //参数配置
        pro.setProperty("mail.transport.protocol","smtp");    //使用协议
        pro.setProperty("mail.smtp.host","smtp.163.com");     //发件人的邮箱的SMTP服务地址
        pro.setProperty("mail.smtp.auth","true");            //需要请求认证
        pro.setProperty("mail.smtp.port","25");            //需要请求认证

        //2.获取session对象
        Session session = Session.getDefaultInstance(pro);

        //3.封装messgae对象
        MimeMessage message = createMimeMessage(session,account,receiveMailAccount);

        //4.使用Transport发送邮件
        Transport transport = session.getTransport();
        transport.connect(account,password);
        transport.sendMessage(message,message.getAllRecipients());
        //5.关闭连接
        transport.close();
    }

    /**
     * 封装邮件信息进message对象
     * @param session 邮件对象
     * @param sendMail
     * @param receiveMail
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session,String sendMail,String receiveMail) throws  Exception{
        //1.创建一封邮件
        MimeMessage message = new MimeMessage(session);
        //2.From:发件人
        message.setFrom(new InternetAddress(sendMail,"1090266178","UTF-8"));
        //3.To:收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(receiveMail,"亲爱的用户","UTF-8"));
        //4.Subject:邮件主题
        message.setSubject("主题内容","UTF-8");
        //5.Content:邮件正文
        message.setContent("<h1>亲亲用户你好你好呀</h1>","text/html;charset=UTF-8");
        //6.设置发件时间
        message.setSentDate(new Date());
        //7.保存设置
        message.saveChanges();
        return message;
    }
    public static void main(String[] ags) throws Exception {
        sendMessages("h1090266178@163.com","ELJWLAALXOUYITOG","0@qq.com");
    }
}
