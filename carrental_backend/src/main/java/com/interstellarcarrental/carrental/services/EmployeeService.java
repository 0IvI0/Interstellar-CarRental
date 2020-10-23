package com.interstellarcarrental.carrental.services;

import java.sql.Date;
import java.util.List;

import com.interstellarcarrental.carrental.dto.DTOconverter;
import com.interstellarcarrental.carrental.dto.EmployeeDTO;
import com.interstellarcarrental.carrental.models.Employee;
import com.interstellarcarrental.carrental.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    static final String NOTFOUND_MESSAGE = "Employee not found.";

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DTOconverter dtoConverter;


//POST method:

    public Employee saveEmployee(EmployeeDTO employeeDto) {
        return employeeRepository.save(dtoConverter.employeeDTOtoEntity(employeeDto));
    }

    public List<Employee> saveEmployees(List<EmployeeDTO> employeesDto) {
        return employeeRepository.saveAll(dtoConverter.employeeListDTOtoEntity(employeesDto));
    }


//GET method:

    public List<EmployeeDTO> getEmployees() {
        return dtoConverter.employeeListEntityToDTO(employeeRepository.findAll());
    }

    public EmployeeDTO getEmployeeByUsername(String username) {
        return dtoConverter.employeeEntityToDTO(employeeRepository.findByUsername(username));
    }

    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<EmployeeDTO> getEmployeeByLastNameIgnoreCaseOrderByFirstNameAsc(String lastName) {
        return dtoConverter.employeeListEntityToDTO(employeeRepository.findByLastNameIgnoreCaseOrderByFirstNameAsc(lastName));
    }

    public List<EmployeeDTO> getEmployeeByLastName(String lastName) {
        return dtoConverter.employeeListEntityToDTO(employeeRepository.findByLastNameIgnoreCase(lastName));
    }

    public List<EmployeeDTO> getEmployeeByFirstName(String firstName) {
        return dtoConverter.employeeListEntityToDTO(employeeRepository.findByFirstNameIgnoreCase(firstName));
    }

    public List<EmployeeDTO> getEmployeeByBirthDate(Date birthDate) {
        return dtoConverter.employeeListEntityToDTO(employeeRepository.findByBirthDate(birthDate));
    }

    public EmployeeDTO getEmployeeByEmailAddress(String emailAddress) {
        return dtoConverter.employeeEntityToDTO(employeeRepository.findByEmailAddressIgnoreCase(emailAddress));
    }


//DELETE method:

    public String deleteEmployeeById(long id) {
        if (!employeeRepository.findById(id).isPresent()) {
            return "No employee found with the provided ID.";
        }
        employeeRepository.deleteById(id);
        return "Employee with the ID: " + id + " successfully deleted!";
    }


//PUT method:

    public String updateEmailAddress(Employee employee, String newEmailAddress) {
        if (employeeRepository.findById(employee.getId()).isPresent()) {
        employeeRepository.findById(employee.getId()).get().setEmailAddress(newEmailAddress);
        return "The e-mail address of the employee with the ID: " + employee.getId() + " has been changed. Current e-mail address: " + employee.getEmailAddress();
        }
        return NOTFOUND_MESSAGE;
    }

    public String updatePhoneNumber(Employee employee, String newPhoneNumber) {
        if (employeeRepository.findById(employee.getId()).isPresent()) {
        employeeRepository.findById(employee.getId()).get().setPhoneNumber(newPhoneNumber);
        return "The phone number of the employee with the ID: " + employee.getId() + " has been changed. Current phone number: " + employee.getPhoneNumber();
        }
        return NOTFOUND_MESSAGE;
    }

    public String updateAddress(Employee employee, String newAddress) {
        if (employeeRepository.findById(employee.getId()).isPresent()) {
        employeeRepository.findById(employee.getId()).get().setAddress(newAddress);
        return "The address of the employee with the ID: " + employee.getId() + " has been changed. Current address: " + employee.getAddress();
        }
        return NOTFOUND_MESSAGE;
    }

    public String updateCreditCardNumber(Employee employee, String newCreditCardNumber) {
        if (employeeRepository.findById(employee.getId()).isPresent()) {
        employeeRepository.findById(employee.getId()).get().setCreditCardNumber(newCreditCardNumber);
        return "The credit card number of the employee with the ID: " + employee.getId() + " has been changed. Current credit card number: " + employee.getCreditCardNumber();
        }
        return NOTFOUND_MESSAGE;
    }   
}