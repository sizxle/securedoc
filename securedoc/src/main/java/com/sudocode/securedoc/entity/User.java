package com.sudocode.securedoc.entity;

import java.time.LocalDateTime;

public class User extends Auditable{

    private String userId;

    private String firstName;
    private String lastName;
    private String email;
    private Integer loginAttempts;
    private LocalDateTime lastLogin;
    private String phone;
    private String bio;
    private String imgUrl;
    private boolean accountNonExpired; //For spring security
    private boolean accountNonLocked;
    private boolean enabled;
    private boolean mfa;
    private String qrCodeSecret;
    private String qrCodeImgUri;

    private String roles; //TODO create roles class and map here with JPA


}
