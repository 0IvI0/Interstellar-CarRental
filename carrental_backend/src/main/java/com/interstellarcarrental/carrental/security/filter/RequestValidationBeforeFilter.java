package com.interstellarcarrental.carrental.security.filter;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.util.StringUtils;


public class RequestValidationBeforeFilter implements Filter {

    public static final String AUTHENTICATION_SCHEME_BASIC = "Basic";
    private Charset credentialCharset = StandardCharsets.UTF_8;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String header = req.getHeader(AUTHORIZATION);

        if (header != null) {
            header = header.trim();
            if (StringUtils.startsWithIgnoreCase(header, AUTHENTICATION_SCHEME_BASIC)) {
                byte[] base64Token = header.substring(6).getBytes(StandardCharsets.UTF_8);
                byte[] decoded;

                try {
                    decoded = Base64.getDecoder().decode(base64Token);
                    String token = new String(decoded, getCredentialCharset(req));
                    int delimeter = token.indexOf(":");
                    if (delimeter == -1) {
                        throw new BadCredentialsException("Invalid basic authentication token!");
                    }   
                } catch (IllegalArgumentException e) {
                    throw new BadCredentialsException("Unsuccessful decoding of basic authentication token!");
                }
            }
        }
        chain.doFilter(request, response);
    }

    protected Charset getCredentialCharset(HttpServletRequest request) {
        return getCredentialCharset();
    }

    public Charset getCredentialCharset() {
        return this.credentialCharset;
    }
    
}