package com.sudocode.securedoc.service.impl;

import com.sudocode.securedoc.exception.ApiException;
import com.sudocode.securedoc.service.EmailService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    public static final String NEW_ACCOUNT_VERIFICATION = "NEW ACCOUNT VERIFICATION";
    public static final String PASSWORD_RESET = "PASSWORD RESET";
    private final JavaMailSender sender;

    @Value("${spring.mail.verify.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Override
    @Async
    public void sendNewAccountEmail(String name, String to, String token) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(NEW_ACCOUNT_VERIFICATION);
            message.setFrom(fromEmail);
            message.setTo(to);
            message.setText(getNewAccountEmailMessage(name,host,token));

        }catch (Exception exception){
            log.error(exception.getMessage());
            throw new ApiException("Unable to send email");
        }
    }

    @Override
    @Async
    public void sendPasswordReset(String name, String to, String token) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(PASSWORD_RESET);
            message.setFrom(fromEmail);
            message.setTo(to);
            message.setText(getPasswordResetMessage(name,host,token));

        }catch (Exception exception){
            log.error(exception.getMessage());
            throw new ApiException("Unable to send email");
        }
    }
}
