package com.interstellarcarrental.carrental.security;

import java.security.Principal;

import com.interstellarcarrental.carrental.dto.CustomerDTO;
import com.interstellarcarrental.carrental.dto.EmployeeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/auth/login")
    public ResponseEntity<CustomerDTO> getCurrentCustomerDetails(@NonNull Principal user) {
            if (appUserService.getCurrentCustomer(user.getName()) != null) {
                return new ResponseEntity<>(appUserService.getCurrentCustomer(user.getName()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
    }

    @PostMapping("/employee/authenticate")
    public ResponseEntity<EmployeeDTO> getCurrentEmployeeDetails(@NonNull Principal user) {
        if (appUserService.getCurrentEmployee(user.getName()) != null) {
            return new ResponseEntity<>(appUserService.getCurrentEmployee(user.getName()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}