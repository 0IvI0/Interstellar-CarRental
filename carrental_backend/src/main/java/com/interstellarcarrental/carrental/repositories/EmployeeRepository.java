package com.interstellarcarrental.carrental.repositories;

import java.sql.Date;
import java.util.List;

import com.interstellarcarrental.carrental.models.Employee;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByUsername(String username);
    Employee findByEmployeeID(String employeeID);
    Employee findByEmailAddressIgnoreCase(String emailAddress);
    List<Employee> findByLastNameIgnoreCase(String lastName);
    List<Employee> findByFirstNameIgnoreCase(String firstName);
    List<Employee> findByBirthDate(Date birthDate);
    List<Employee> findByUserRole(String userRole);

    List<Employee> findByLastNameIgnoreCaseOrderByFirstNameAsc(String lastName);  
}
