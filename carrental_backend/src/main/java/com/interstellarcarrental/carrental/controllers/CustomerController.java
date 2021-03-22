package com.interstellarcarrental.carrental.controllers;

import java.time.LocalDate;
import java.util.List;

import com.interstellarcarrental.carrental.dto.CustomerDTO;
import com.interstellarcarrental.carrental.services.CustomerService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


//POST MAPPING

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String registerCustomer(@RequestBody CustomerDTO customerDto) {
        CustomerDTO newCustomerDto = new CustomerDTO();
        BeanUtils.copyProperties(customerDto, newCustomerDto);
        return customerService.saveCustomer(newCustomerDto);
    }


//GET MAPPING

//For employee

    @GetMapping("/employee/listCustomers")
    public List<CustomerDTO> listCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/employee/listCustomer/{username}")
    public CustomerDTO getCustomerOfUsername(@PathVariable String username) {
        return customerService.getCustomerByUsername(username);
    }

    @GetMapping("/employee/listCustomer/{lastName}")
    public List<CustomerDTO> listCustomersMatchingLastName(@PathVariable String lastName) {
        return customerService.getCustomerByLastNameIgnoreCaseOrderByFirstNameAsc(lastName);
    }

    @GetMapping("/employee/listCustomer/{firstName}")
    public List<CustomerDTO> listCustomersMatchingFirstName(@PathVariable String firstName) {
        return customerService.getCustomerByFirstName(firstName);
    }

    @GetMapping("/employee/listCustomer/{birthDate}")
    public List<CustomerDTO> listCustomersByBirthDate(@PathVariable LocalDate birthdate) {
        return customerService.getCustomerByBirthDate(birthdate);
    }

    @GetMapping("/employee/listCustomer/{emailAddress}")
    public CustomerDTO getCustomerMatchingEmailAddress(@PathVariable String emailAddress) {
        return customerService.getCustomerByEmailAddress(emailAddress);
    }
}