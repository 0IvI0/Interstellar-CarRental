package com.interstellarcarrental.carrental.dto;

import java.sql.Date;
import java.util.List;

import com.interstellarcarrental.carrental.models.Invoice;

import lombok.Data;


@Data
public class EmployeeDTO {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String emailAddress;
    private String phoneNumber;
    private String address;
    private String creditCardNumber;
    private String employeeID;

    private List<Invoice> invoiceList;
}