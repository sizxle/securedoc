package com.sudocode.securedoc.service;

public interface EmailService {

    void sendNewAccountEmail(String name, String to, String token);
    void sendPasswordReset(String name, String to , String token);

}
