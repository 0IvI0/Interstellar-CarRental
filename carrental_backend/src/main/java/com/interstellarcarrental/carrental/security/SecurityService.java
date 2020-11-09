package com.interstellarcarrental.carrental.security;

import com.interstellarcarrental.carrental.models.Customer;
import com.interstellarcarrental.carrental.repositories.CustomerRepository;
import com.interstellarcarrental.carrental.security.userDetailsImpl.CustomerDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUsername(username);

        if (customer == null) {
            throw new UsernameNotFoundException("Credentials don't exist.");
        }
        
        return new CustomerDetails(customer);
    }   
}