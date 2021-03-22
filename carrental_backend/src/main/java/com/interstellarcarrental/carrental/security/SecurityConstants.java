package com.interstellarcarrental.carrental.security;

public class SecurityConstants {
    
    public static final String JWT_KEY = "sdfjDFG73Hdfe8sLVcmw41p0B9q7Fb5V";
    public static final String JWT_HEADER = "Authorization";

    private SecurityConstants() {
        throw new IllegalStateException("Security Constants: Class for static constants");
    }
}