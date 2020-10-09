package com.interstellarcarrental.carrental.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String emailAddress;
    private String phoneNumber;
    private String address;
    private String creditCardNumber;
    private List<Invoice> invoiceList;


    public String getCustomerName() {
         return this.firstName + " " + this.lastName;
    } 
}
