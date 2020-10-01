package com.interstellarcarrental.carrental.models;

import java.sql.Date;

import lombok.Data;


@Data
public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String emailAddress;
    private String phoneNumber;
    private String address;
    private String creditCardNumber;


    public String getCustomerName() {
         return this.firstName + " " + this.lastName;
    }
    
}
