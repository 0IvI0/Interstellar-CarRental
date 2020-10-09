package com.interstellarcarrental.carrental.models;

import java.sql.Date;
import java.util.List;

import lombok.Data;


@Data
public class AllUsers {

    protected String username;
    protected String password;
    protected final String userRole;
    protected String firstName;
    protected String lastName;
    protected Date birthDate;
    protected String emailAddress;
    protected String phoneNumber;
    protected String address;
    protected String creditCardNumber;
    protected List<Invoice> invoiceList;


    public String getUsersName() {
         return this.firstName + " " + this.lastName;
    }
}