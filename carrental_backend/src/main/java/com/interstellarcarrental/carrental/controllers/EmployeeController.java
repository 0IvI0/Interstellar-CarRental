package com.interstellarcarrental.carrental.controllers;

import java.time.LocalDate;
import java.util.List;

import com.interstellarcarrental.carrental.dto.EmployeeDTO;
import com.interstellarcarrental.carrental.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    
//POST MAPPING

    @PostMapping("/admin/createEmployee")
    public String saveEmployee(EmployeeDTO employeeDto) {
        employeeService.saveEmployee(employeeDto);
        return "Registration of new employee successful!";
    }


//GET MAPPING

//For manager

   @GetMapping("/mngr/listEmployees")
    public List<EmployeeDTO> listEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("mngr/listEmployee/{username}")
    public EmployeeDTO getEmployeeOfUsername(@PathVariable String username) {
        return employeeService.getEmployeeByUsername(username);
    }

    @GetMapping("mngr/listEmployee/{lastName}")
    public List<EmployeeDTO> listEmployeesMatchingLastName(@PathVariable String lastName) {
        return employeeService.getEmployeeByLastNameIgnoreCaseOrderByFirstNameAsc(lastName);
    }

    @GetMapping("/mngr/listEmployee/{firstName}")
    public List<EmployeeDTO> listEmployeesMatchingFirstName(@PathVariable String firstName) {
        return employeeService.getEmployeeByFirstName(firstName);
    }

    @GetMapping("/mngr/listEmployee/{birthDate}")
    public List<EmployeeDTO> listEmployeesByBirthDate(@PathVariable LocalDate birthdate) {
        return employeeService.getEmployeeByBirthDate(birthdate);
    }

    @GetMapping("/mngr/listEmployee/{emailAddress}")
    public EmployeeDTO getEmployeeMatchingEmailAddress(@PathVariable String emailAddress) {
        return employeeService.getEmployeeByEmailAddress(emailAddress);
    }
}