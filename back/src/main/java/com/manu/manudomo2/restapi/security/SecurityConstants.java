package com.manu.manudomo2.restapi.security;

public class SecurityConstants {

    private SecurityConstants(){
        // Hide public constructor
    }

    public static final String SECRET = "4kjg4f6g5fd4s67hg65gf4d65fdgg465fsdg";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String PUBLIC_URL = "/public/**";
}
