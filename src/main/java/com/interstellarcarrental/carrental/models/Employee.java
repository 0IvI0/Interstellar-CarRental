package com.interstellarcarrental.carrental.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class Employee extends AllUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    public Employee() {
        super("EMPLOYEE_STANDARD");
    }
}