package com.interstellarcarrental.carrental.dto;

import java.util.ArrayList;
import java.util.List;

import com.interstellarcarrental.carrental.models.Car;
import com.interstellarcarrental.carrental.models.Customer;
import com.interstellarcarrental.carrental.models.Employee;
import com.interstellarcarrental.carrental.models.Invoice;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


@Component
public class DTOconverter {
    
    // CAR ENTITY <-> DTO

    public CarDTO carEntityToDTO(Car car) {
        CarDTO newCarDTO = new CarDTO();
        BeanUtils.copyProperties(car, newCarDTO);
        return newCarDTO;
    }

    public List<CarDTO> carListEntityToDTO(List<Car> cars) {
        List<CarDTO> newCars = new ArrayList<>();
        for (Car car : cars) {
            CarDTO newCarDto = new CarDTO();
            BeanUtils.copyProperties(car, newCarDto);
            newCars.add(newCarDto);
        }
        return newCars;
    }

    public Car carDTOtoEntity(CarDTO carDto) {
        Car newCar = new Car();
        BeanUtils.copyProperties(carDto, newCar);
        return newCar;
    }

    public List<Car> carListDTOtoEntity(List<CarDTO> carsDto) {
        List<Car> newCarList = new ArrayList<>();
        for (CarDTO carDto : carsDto) {
            Car newCar = new Car();
            BeanUtils.copyProperties(carDto, newCar);
            newCarList.add(newCar);
        }
        return newCarList;
    }


    // CUSTOMER ENTITY <-> DTO

    public CustomerDTO customerEntityToDTO(Customer customer) {
        CustomerDTO newCustomerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, newCustomerDTO);
        return newCustomerDTO;
    }

    public List<CustomerDTO> customerListEntityToDTO(List<Customer> customers) {
        List<CustomerDTO> newCustomersListDto = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDTO newCustomerDto = new CustomerDTO();
            BeanUtils.copyProperties(customer, newCustomerDto);
            newCustomersListDto.add(newCustomerDto);
        }
        return newCustomersListDto;
    }

    public Customer customerDTOtoEntity(CustomerDTO customerDTO) {
        Customer newCustomer = new Customer();
        BeanUtils.copyProperties(customerDTO, newCustomer);
        return newCustomer;
    }

    public List<Customer> customerListDTOtoEntity(List<CustomerDTO> customersDto) {
        List<Customer> newCustomersList = new ArrayList<>();
        for (CustomerDTO customerDto : customersDto) {
            Customer newCustomer = new Customer();
            BeanUtils.copyProperties(customerDto, newCustomer);
            newCustomersList.add(newCustomer);
        }
        return newCustomersList;
    }


    //EMPLOYEE ENTITY <-> DTO

    public EmployeeDTO employeeEntityToDTO(Employee employee) {
        EmployeeDTO newEmployeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee, newEmployeeDTO);
        return newEmployeeDTO;
    }

    public List<EmployeeDTO> employeeListEntityToDTO(List<Employee> employees) {
        List<EmployeeDTO> newEmployeeListDto = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDTO newEmployeeDto = new EmployeeDTO();
            BeanUtils.copyProperties(employee, newEmployeeDto);
            newEmployeeListDto.add(newEmployeeDto);
        }
        return newEmployeeListDto;
    }

    public Employee employeeDTOtoEntity(EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee();
        BeanUtils.copyProperties(employeeDTO, newEmployee);
        return newEmployee;
    }

    public List<Employee> employeeListDTOtoEntity(List<EmployeeDTO> employeesDto) {
        List<Employee> newEmployeesList = new ArrayList<>();
        for (EmployeeDTO employeeDto : employeesDto) {
            Employee newEmployee = new Employee();
            BeanUtils.copyProperties(employeeDto, newEmployee);
            newEmployeesList.add(newEmployee);
        }
        return newEmployeesList;
    }


    // INVOICE ENTITY <-> DTO

    public InvoiceDTO invoiceEntityToDTO(Invoice invoice) {
        InvoiceDTO newInvoiceDTO = new InvoiceDTO(invoice.getInvoiceOwner());
        BeanUtils.copyProperties(invoice, newInvoiceDTO);
        return newInvoiceDTO;
    }

    public List<InvoiceDTO> invoiceListEntityToDTO(List<Invoice> invoices) {
        List<InvoiceDTO> newInvoiceListDto = new ArrayList<>();
        for (Invoice invoice : invoices) {
            InvoiceDTO newInvoiceDto = new InvoiceDTO(invoice.getInvoiceOwner());
            BeanUtils.copyProperties(invoice, newInvoiceDto);
            newInvoiceListDto.add(newInvoiceDto);
        }
        return newInvoiceListDto;
    }

    public Invoice invoiceDTOtoEntity(InvoiceDTO invoiceDTO) {
        Invoice newInvoice = new Invoice(invoiceDTO.getInvoiceOwner());
        BeanUtils.copyProperties(invoiceDTO, newInvoice);
        return newInvoice;
    }

    public List<Invoice> invoiceListDTOtoEntity(List<InvoiceDTO> invoicesDto) {
        List<Invoice> newInvoiceList = new ArrayList<>();
        for (InvoiceDTO invoiceDto : invoicesDto) {
            Invoice newInvoice = new Invoice(invoiceDto.getInvoiceOwner());
            BeanUtils.copyProperties(invoiceDto, newInvoice);
            newInvoiceList.add(newInvoice);
        }
        return newInvoiceList;
    }
}