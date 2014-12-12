package com.safewind.dmucms.domain;

import java.io.Serializable;

public class Email implements Serializable {

    private static final long serialVersionUID = 2039114195041733741L;
    
    private String[] EmailAddressee;  // 收件人
    private String EmailCc;  //抄送
    private String EmailSubject;  // 邮件主题
    private String EmailContent;  // 邮件内容
  //private MultipartFile[] attachment = new MultipartFile[0];  //附件

    public String getEmailCc() {
        return EmailCc;
    }
    public String[] getEmailAddressee() {
        return EmailAddressee;
    }
    public void setEmailAddressee(String[] emailAddressee) {
        EmailAddressee = emailAddressee;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public void setEmailCc(String emailCc) {
        EmailCc = emailCc;
    }
    public String getEmailSubject() {
        return EmailSubject;
    }
    public void setEmailSubject(String emailSubject) {
        EmailSubject = emailSubject;
    }
    public String getEmailContent() {
        return EmailContent;
    }
    public void setEmailContent(String emailContent) {
        EmailContent = emailContent;
    }
}
