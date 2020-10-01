package com.interstellarcarrental.carrental.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue
    private long id;
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
