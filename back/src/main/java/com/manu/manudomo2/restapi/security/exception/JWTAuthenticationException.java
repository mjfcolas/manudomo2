package com.manu.manudomo2.restapi.security.exception;

import  org.springframework.security.core.AuthenticationException;

public class JWTAuthenticationException extends AuthenticationException {

    public JWTAuthenticationException(String message, Exception e){
        super(message, e);
    }
}
