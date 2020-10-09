package com.interstellarcarrental.carrental.dto;

import java.util.ArrayList;
import java.util.List;

import com.interstellarcarrental.carrental.models.Car;
import com.interstellarcarrental.carrental.models.Customer;
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
        BeanUtils.copyProperties(cars, newCars);
        return newCars;
    }

    public Car carDTOtoEntity(CarDTO carDto) {
        Car newCar = new Car();
        BeanUtils.copyProperties(carDto, newCar);
        return newCar;
    }

    public List<Car> carListDTOtoEntity(List<CarDTO> carsDto) {
        List<Car> newCarList = new ArrayList<>();
        BeanUtils.copyProperties(carsDto, newCarList);
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
        BeanUtils.copyProperties(customers, newCustomersListDto);
        return newCustomersListDto;
    }

    public Customer customerDTOtoEntity(CustomerDTO customerDTO) {
        Customer newCustomer = new Customer();
        BeanUtils.copyProperties(customerDTO, newCustomer);
        return newCustomer;
    }

    public List<Customer> customerListDTOtoEntity(List<CustomerDTO> customersDto) {
        List<Customer> newCustomersList = new ArrayList<>();
        BeanUtils.copyProperties(customersDto, newCustomersList);
        return newCustomersList;
    }


    // INVOICE ENTITY <-> DTO

    public InvoiceDTO invoiceEntityToDTO(Invoice invoice) {
        InvoiceDTO newInvoiceDTO = new InvoiceDTO();
        BeanUtils.copyProperties(invoice, newInvoiceDTO);
        return newInvoiceDTO;
    }

    public List<InvoiceDTO> invoiceListEntityToDTO(List<Invoice> invoices) {
        List<InvoiceDTO> newInvoiceListDto = new ArrayList<>();
        BeanUtils.copyProperties(invoices, newInvoiceListDto);
        return newInvoiceListDto;
    }

    public Invoice invoiceDTOtoEntity(InvoiceDTO invoiceDTO) {
        Invoice newInvoice = new Invoice(invoiceDTO.getInvoiceOwner());
        BeanUtils.copyProperties(invoiceDTO, newInvoice);
        return newInvoice;
    }

    public List<Invoice> invoiceListDTOtoEntity(List<InvoiceDTO> invoicesDto) {
        List<Invoice> newInvoiceList = new ArrayList<>();
        BeanUtils.copyProperties(invoicesDto, newInvoiceList);
        return newInvoiceList;
    }
}
