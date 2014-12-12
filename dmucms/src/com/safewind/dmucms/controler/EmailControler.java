package com.safewind.dmucms.controler;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.safewind.dmucms.domain.Email;
import com.safewind.dmucms.service.IEmailService;

@Controller
public class EmailControler {
    
    private static final Logger logger = LoggerFactory.getLogger(EmailControler.class);
    
    @Autowired
    private IEmailService EmailServiceImpl ;
    
    
    @RequestMapping(value = "/center/sendMail", method=RequestMethod.GET)
    public String getSendMailPage(){
        return "center/edit_mail";
      }
    
    @RequestMapping(value = "/center/sendMail", method=RequestMethod.POST)
    public String doSendMail(
            @RequestParam(value="EmailAddressee") String EmailAddressee ,
            @RequestParam(value="EmailSubject") String EmailSubject ,
            @RequestParam(value="EmailContent") String EmailContent ,
            HttpServletRequest request
            ){
        
        logger.info("------------------谢谢 ----------------");
        
        String array[] = {"593985368@qq.com","906165957@qq.com"} ;
        
        String temp = "<html> <body> <h2 style=" + "color:red" + ">你好，你好！</h2> </body> </html>" ;
        
        logger.info(" -------- "  + temp);
        
        Email email = new Email();
        email.setEmailAddressee(array);
        email.setEmailContent(temp);
        email.setEmailSubject("大创系统-----");
        try {
            EmailServiceImpl.sendMail(email);  //大于5个收件人时，分流器会自动选择异步方式发送
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  
        return "message";
      }
}
