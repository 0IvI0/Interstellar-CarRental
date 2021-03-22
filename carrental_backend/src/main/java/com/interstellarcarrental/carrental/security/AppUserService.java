package com.interstellarcarrental.carrental.security;

import com.interstellarcarrental.carrental.dto.CustomerDTO;
import com.interstellarcarrental.carrental.dto.DTOconverter;
import com.interstellarcarrental.carrental.dto.EmployeeDTO;
import com.interstellarcarrental.carrental.repositories.CustomerRepository;
import com.interstellarcarrental.carrental.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppUserService {
    
    static final String NOTFOUND_MSG = "Customer not found. Customer does not exist or the credentials are invalid.";

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DTOconverter dtoConverter;

    
    // GET USER DETAILS OF CURRENT USER AFTER LOGIN - CUSTOMER LOGIN:
    public CustomerDTO getCurrentCustomer(String currentUsername) {
        if (customerRepository.findByUsername(currentUsername) != null) {
            return dtoConverter.customerEntityToDTO(customerRepository.findByUsername(currentUsername));
        }
        return null;
    }

    // GET USER DETAILS OF CURRENT USER AFTER LOGIN - EMPLOYEE LOGIN:
    public EmployeeDTO getCurrentEmployee(String currentUsername) {
        if (employeeRepository.findByUsername(currentUsername) != null) {
            return dtoConverter.employeeEntityToDTO(employeeRepository.findByUsername(currentUsername));
        }
        return null;
    }
}