package com.safewind.dmucms.service.Impl;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.safewind.dmucms.dao.EmailDao;
import com.safewind.dmucms.domain.Email;
import com.safewind.dmucms.service.IEmailService;

@Service
public class EmailServiceImpl implements IEmailService {
    
    
    @Autowired 
    JavaMailSender mailSender;  //装配Spring封装的javamail 
    @Autowired 
    TaskExecutor taskExecutor;   //装配Spring封装的异步执行器
    @Autowired
    private EmailDao emailDao ; 

    public void sendMail(Email email) throws MessagingException, IOException {

        /*
         * if(email.getEmailAddressee() == null || email.getEmailAddressee().length == 0){ this.message.append("没有收件人"); return; }
         */

        if (email.getEmailAddressee().length > 5) {
            // 收件人大于5封时，采用异步发送
            sendMailByAsynchronousMode(email);
        } else {
            //以同步方式发送邮件
            sendMailBySynchronizationMode(email);
        }
    }

    /**
     * 异步发送
     * 
     */
    public void sendMailByAsynchronousMode(final Email email) {
        taskExecutor.execute(new Runnable() {
            public void run() {
                try {
                    sendMailBySynchronizationMode(email);
                } catch (Exception e) {
                }
            }
        });
    }

    /**
     * 同步发送
     * 
     */
    public void sendMailBySynchronizationMode(Email email) throws MessagingException, IOException {
        String[] emailAdrressArray = email.getEmailAddressee();
        MimeMessage mime = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mime, true, "utf-8");
        helper.setFrom("shugang.cpp@gmail.com");// 发件人       
        helper.setReplyTo("shugang.cpp@gmail.com");// 回复到
        helper.setSubject(email.getEmailSubject());// 邮件主题
        helper.setText(email.getEmailContent(), true);// true表示设定html格式
         for(int i = 0 ;  i < emailAdrressArray.length ; i ++)
        {
            helper.setTo(emailAdrressArray[i]);// 收件人
            mailSender.send(mime);
        }
    }

	@Override
	public List<String> getAllEmailAdress()
	{
		return emailDao.queryAllEmailAdress();
	}
}
