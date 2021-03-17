package com.interstellarcarrental.carrental.repositories;

import java.time.LocalDate;
import java.util.List;

import com.interstellarcarrental.carrental.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUsername(String username);
    User findByEmailAddressIgnoreCase(String emailAddress);

    List<User> findByUserRole(String role);
    List<User> findByLastNameIgnoreCase(String lastName);
    List<User> findByFirstNameIgnoreCase(String firstName);
    List<User> findByBirthDate(LocalDate birthDate);
    List<User> findByLastNameIgnoreCaseOrderByFirstNameAsc(String lastName);
}