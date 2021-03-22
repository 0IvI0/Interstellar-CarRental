package com.interstellarcarrental.carrental.controllers;

import java.util.List;

import com.interstellarcarrental.carrental.dto.InvoiceDTO;
import com.interstellarcarrental.carrental.dto.UserDTO;
import com.interstellarcarrental.carrental.services.InvoiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/employee")
public class InvoiceController {
    
    @Autowired
    private InvoiceService invoiceService;


    //POST MAPPING

    @PostMapping("/createInvoice")
    public String saveInvoice(InvoiceDTO invoiceDto) {
        invoiceService.saveInvoice(invoiceDto);
        return "Invoice has been created.";
    }


    //GET MAPPING

    //Only for employee
    @GetMapping("/listInvoices")
    public List<InvoiceDTO> listInvoices() {
        return invoiceService.getInvoices();
    }

    @GetMapping("/listInvoices/{invoiceOwner}")
    public List<InvoiceDTO> listInvoicesOfOwner(@PathVariable UserDTO invoiceOwner) {
        return invoiceService.getInvoiceByInvoiceOwner(invoiceOwner);
    }

    @GetMapping("/listInvoices/{invoiceNr}")
    public InvoiceDTO getInvoiceMatchingInvoiceNumber(@PathVariable int invoiceNr) {
        return invoiceService.getInvoiceByInvoiceNumber(invoiceNr);
    }

    @GetMapping("/listInvoices/{isPaid}")
    public List<InvoiceDTO> listPaidInvoices(@PathVariable boolean isPaid) {
        return invoiceService.getInvoiceByPaidInvoice(isPaid);
    }
}
