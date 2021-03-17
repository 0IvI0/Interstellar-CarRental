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
@Table(name = "CUSTOMER")
@SuperBuilder
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Customer extends User {

    @Column(name = "TEST_USER_ROLE", nullable = false)
    private final String userRole = "CUSTOMER";

    /* @Column(name = "INVOICES") */
    @OneToMany
    private List<Invoice> invoiceList;
}