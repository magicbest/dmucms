package com.safewind.dmucms.service;

import java.io.IOException;

import javax.mail.MessagingException;

import com.safewind.dmucms.domain.Email;

public interface IEmailService {

    void sendMail(Email email) throws MessagingException, IOException;

}
