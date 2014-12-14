package com.safewind.dmucms.controler;

import java.io.IOException;
import java.util.List;

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
        return "center/mail_page";
      }
    
    @RequestMapping(value = "/center/sendMail", method=RequestMethod.POST)
    public String doSendMail(
    		@RequestParam(value="sendAll" , required = false) String sendAll ,
            @RequestParam(value="EmailAddressee") String EmailAddressee ,
            @RequestParam(value="EmailSubject") String EmailSubject ,
            @RequestParam(value="EmailContent") String EmailContent ,
            HttpServletRequest request
            ){
        
    	logger.info("---------" + sendAll) ;
    	
    	if(sendAll != null)
    	{
    		List<String> emaiList =  EmailServiceImpl.getAllEmailAdress();
    		logger.info("需要发送多少分邮件 ： " + emaiList.size());
            String[] array =new String[emaiList.size()];
            for(int i = 0 ;  i < emaiList.size() ;  i ++)
            {
            	array[i] = (String)emaiList.get(i);
            }
            
            Email email = new Email();
            email.setEmailAddressee(array);
            email.setEmailContent(EmailContent);
            email.setEmailSubject(EmailSubject);
            try {
                EmailServiceImpl.sendMail(email);  
            } catch (MessagingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }  
            
    	}
        return "redirect:/";
      }
}
