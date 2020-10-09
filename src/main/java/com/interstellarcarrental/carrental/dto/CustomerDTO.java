package com.interstellarcarrental.carrental.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class CustomerDTO {

    private String username;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String emailAddress;
    private String phoneNumber;
    private String address;
    private String creditCardNumber;
}
