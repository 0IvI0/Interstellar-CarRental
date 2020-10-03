package com.interstellarcarrental.carrental.services;

import java.sql.Date;
import java.util.List;

import com.interstellarcarrental.carrental.models.Customer;
import com.interstellarcarrental.carrental.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;


//POST method:

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> saveCustomers(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }


//GET method:

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> getCustomerByLastnameIgnoreCaseOrderByFirstnameAsc(String lastname) {
        return customerRepository.findByLastnameIgnoreCaseOrderByFirstnameAsc(lastname);
    }

    public List<Customer> getCustomerByLastName(String lastName) {
        return customerRepository.findByLastNameIgnoreCase(lastName);
    }

    public List<Customer> getCustomerByFirstName(String firstName) {
        return customerRepository.findByFirstNameIgnoreCase(firstName);
    }

    public List<Customer> getCustomerByBirthDate(Date birthDate) {
        return customerRepository.findByBirthDate(birthDate);
    }

    public Customer getCustomerByEmailAddress(String emailAddress) {
        return customerRepository.findByEmailAddressIgnoreCase(emailAddress);
    }
}
