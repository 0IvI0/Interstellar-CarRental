package com.interstellarcarrental.carrental.services;

import java.sql.Date;
import java.util.List;

import com.interstellarcarrental.carrental.models.Customer;
import com.interstellarcarrental.carrental.repositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

    static final String NOTFOUND_MESSAGE = "Customer not found.";
    
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


    //DELETE method:

    public String deleteCustomerById(long id) {
        if (!customerRepository.findById(id).isPresent()) {
            return "No customer found with the provided ID.";
        }
        customerRepository.deleteById(id);
        return "Customer with the ID: " + id + " successfully deleted!";
    }


    //PUT method:

    public String updateEmailAddress(Customer customer, String newEmailAddress) {
        if (customerRepository.findById(customer.getId()).isPresent()) {
        customerRepository.findById(customer.getId()).get().setEmailAddress(newEmailAddress);
        return "The e-mail address of the customer with the ID: " + customer.getId() + " has been changed. Current e-mail address: " + customer.getEmailAddress();
        }
        return NOTFOUND_MESSAGE;
    }

    public String updatePhoneNumber(Customer customer, String newPhoneNumber) {
        if (customerRepository.findById(customer.getId()).isPresent()) {
        customerRepository.findById(customer.getId()).get().setPhoneNumber(newPhoneNumber);
        return "The phone number of the customer with the ID: " + customer.getId() + " has been changed. Current phone number: " + customer.getPhoneNumber();
        }
        return NOTFOUND_MESSAGE;
    }

    public String updateAddress(Customer customer, String newAddress) {
        if (customerRepository.findById(customer.getId()).isPresent()) {
        customerRepository.findById(customer.getId()).get().setAddress(newAddress);
        return "The address of the customer with the ID: " + customer.getId() + " has been changed. Current address: " + customer.getAddress();
        }
        return NOTFOUND_MESSAGE;
    }

    public String updateCreditCardNumber(Customer customer, String newCreditCardNumber) {
        if (customerRepository.findById(customer.getId()).isPresent()) {
        customerRepository.findById(customer.getId()).get().setCreditCardNumber(newCreditCardNumber);
        return "The credit card number of the customer with the ID: " + customer.getId() + " has been changed. Current credit card number: " + customer.getCreditCardNumber();
        }
        return NOTFOUND_MESSAGE;
    }
}
