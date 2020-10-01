package com.interstellarcarrental.carrental.repositories;

import java.sql.Date;

import com.interstellarcarrental.carrental.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    Customer findByLastName(String lastName);
    Customer findByFirstName(String firstName);
    Customer findByBirthDate(Date birthDate);
    Customer findByEmailAddress(String emailAddress);
}
