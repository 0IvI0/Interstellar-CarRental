package com.interstellarcarrental.carrental.security;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import com.interstellarcarrental.carrental.app_constants.RoleConstants;
import com.interstellarcarrental.carrental.dto.CustomerDTO;
import com.interstellarcarrental.carrental.dto.EmployeeDTO;
import com.interstellarcarrental.carrental.dto.UserDTO;
import com.interstellarcarrental.carrental.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @PostMapping("/authuser")
    public ResponseEntity<UserDTO> getSessionUserDetails(@NonNull Principal principal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (auth.getAuthorities().equals(authorities.add(new SimpleGrantedAuthority(RoleConstants.ROLE_EMPLOYEE)))) {
            return new ResponseEntity<>(appUserService.getCurrentEmployee(auth.getName()), HttpStatus.OK);
        }
        if (auth.getAuthorities().equals(authorities.add(new SimpleGrantedAuthority(RoleConstants.ROLE_CUSTOMER)))) {
            return new ResponseEntity<>(appUserService.getCurrentCustomer(auth.getName()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }
}