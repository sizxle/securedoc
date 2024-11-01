package com.sudocode.securedoc.entity.exception;

public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }
    public ApiException(){
        super("an error occured");
    }
}
