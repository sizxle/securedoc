package com.sudocode.securedoc.enumeration;

import static com.sudocode.securedoc.constant.Constants.*;

public enum Authority {

    USER(USER_AUTHORITIES),
    ADMIN(ADMIN_AUTHORITIES),
    SUPER_ADMIN(SUPER_ADMIN_AUTHORITIES),
    MANGER(MANGER_AUTHORITIES);

    private final String value;

    private Authority(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
