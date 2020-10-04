package com.interstellarcarrental.carrental.repositories;

import java.sql.Date;
import java.util.List;

import com.interstellarcarrental.carrental.models.Customer;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    List<Customer> findByLastNameIgnoreCase(String lastName);
    List<Customer> findByFirstNameIgnoreCase(String firstName);
    List<Customer> findByBirthDate(Date birthDate);
    Customer findByEmailAddressIgnoreCase(String emailAddress);

    List<Customer> findByLastnameIgnoreCaseOrderByFirstnameAsc(String lastname);
}
