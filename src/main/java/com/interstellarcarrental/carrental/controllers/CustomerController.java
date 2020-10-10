package com.interstellarcarrental.carrental.controllers;

import java.sql.Date;
import java.util.List;

import com.interstellarcarrental.carrental.dto.CustomerDTO;
import com.interstellarcarrental.carrental.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


//POST MAPPING

    @PostMapping("/createCustomer")
    public String saveCustomer(CustomerDTO customerDto) {
        customerService.saveCustomer(customerDto);
        return "Registration successful!";
    }


//GET MAPPING

//For employee

    @GetMapping("/listCustomers")
    public List<CustomerDTO> listCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/listCustomer/{username}")
    public CustomerDTO getCustomerOfUsername(@PathVariable String username) {
        return customerService.getCustomerByUsername(username);
    }

    @GetMapping("/listCustomer/{lastName}")
    public List<CustomerDTO> listCustomersMatchingLastName(@PathVariable String lastName) {
        return customerService.getCustomerByLastnameIgnoreCaseOrderByFirstnameAsc(lastName);
    }

    @GetMapping("/listCustomer/{firstName}")
    public List<CustomerDTO> listCustomersMatchingFirstName(@PathVariable String firstName) {
        return customerService.getCustomerByFirstName(firstName);
    }

    @GetMapping("/listCustomer/{birthDate}")
    public List<CustomerDTO> listCustomersByBirthDate(@PathVariable Date birthdate) {
        return customerService.getCustomerByBirthDate(birthdate);
    }

    @GetMapping("/listCustomer/{emailAddress}")
    public CustomerDTO getCustomerMatchingEmailAddress(@PathVariable String emailAddress) {
        return customerService.getCustomerByEmailAddress(emailAddress);
    }
}