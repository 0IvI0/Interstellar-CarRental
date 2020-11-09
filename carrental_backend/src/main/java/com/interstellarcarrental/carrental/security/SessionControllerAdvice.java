package com.interstellarcarrental.carrental.security;

import java.security.Principal;

import com.interstellarcarrental.carrental.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;


@ControllerAdvice
public class SessionControllerAdvice {

    private final CustomerService customerService;

    @Autowired
    public SessionControllerAdvice(CustomerService customerService) {
        this.customerService = customerService;
    }


    @ModelAttribute("sessionUser")
    public String sessionUserName(@AuthenticationPrincipal Principal principal) {
        return (principal != null ? principal.getName() : null);
    }
}