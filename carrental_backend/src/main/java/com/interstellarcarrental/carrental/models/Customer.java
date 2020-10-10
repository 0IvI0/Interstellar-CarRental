package com.interstellarcarrental.carrental.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "CUSTOMER")
public class Customer extends AllUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    
    public Customer() {
        super("CUSTOMER");
    }
}