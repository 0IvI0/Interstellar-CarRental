package com.interstellarcarrental.carrental.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "EMPLOYEE")
@SuperBuilder
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Employee extends User {

    @Column(name = "TEST_USER_ROLE", nullable = false)
    private final String userRole = "EMPLOYEE";
    
    @Column(name = "EMPLOYEE_ID", nullable = false, unique = true)
    private String employeeID;

    // @Column(name = "INVOICES")
    @OneToMany
    private List<Invoice> invoiceList;
}