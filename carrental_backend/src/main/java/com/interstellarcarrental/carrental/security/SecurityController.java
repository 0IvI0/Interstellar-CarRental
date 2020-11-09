package com.interstellarcarrental.carrental.security;

import com.interstellarcarrental.carrental.dto.CustomerDTO;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SecurityController {
    
    @GetMapping("/api/sessionUser")
    public CustomerDTO sessionUser(@ModelAttribute("sessionUser") String sessionUserName) {
        CustomerDTO newCustomerDto = new CustomerDTO();
        if (sessionUserName != null) {
        newCustomerDto.setUsername(sessionUserName);
        }
        return newCustomerDto;
    }
}