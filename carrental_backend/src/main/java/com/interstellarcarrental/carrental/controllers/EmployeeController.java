package com.interstellarcarrental.carrental.controllers;

import java.sql.Date;
import java.util.List;

import com.interstellarcarrental.carrental.dto.EmployeeDTO;
import com.interstellarcarrental.carrental.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    
//POST MAPPING

    @PostMapping("/company/createEmployee")
    public String saveEmployee(EmployeeDTO employeeDto) {
        employeeService.saveEmployee(employeeDto);
        return "Registration of new employee successful!";
    }


//GET MAPPING

//For manager

   @GetMapping("/company/listEmployees")
    public List<EmployeeDTO> listEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/company/listEmployee/{username}")
    public EmployeeDTO getEmployeeOfUsername(@PathVariable String username) {
        return employeeService.getEmployeeByUsername(username);
    }

    @GetMapping("/company/listEmployee/{lastName}")
    public List<EmployeeDTO> listEmployeesMatchingLastName(@PathVariable String lastName) {
        return employeeService.getEmployeeByLastNameIgnoreCaseOrderByFirstNameAsc(lastName);
    }

    @GetMapping("/company/listEmployee/{firstName}")
    public List<EmployeeDTO> listEmployeesMatchingFirstName(@PathVariable String firstName) {
        return employeeService.getEmployeeByFirstName(firstName);
    }

    @GetMapping("/company/listEmployee/{birthDate}")
    public List<EmployeeDTO> listEmployeesByBirthDate(@PathVariable Date birthdate) {
        return employeeService.getEmployeeByBirthDate(birthdate);
    }

    @GetMapping("/company/listEmployee/{emailAddress}")
    public EmployeeDTO getEmployeeMatchingEmailAddress(@PathVariable String emailAddress) {
        return employeeService.getEmployeeByEmailAddress(emailAddress);
    }
}