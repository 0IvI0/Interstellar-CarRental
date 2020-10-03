package com.interstellarcarrental.carrental.services;

import java.util.List;

import com.interstellarcarrental.carrental.models.Customer;
import com.interstellarcarrental.carrental.models.Invoice;
import com.interstellarcarrental.carrental.repositories.InvoiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;


//POST method:    

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> saveInvoices(List<Invoice> invoices) {
        return invoiceRepository.saveAll(invoices);
    }


//GET method:

    public List<Invoice> getInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    public Invoice getInvoiceByInvoiceOwner(Customer invoiceOwner) {
        return invoiceRepository.findByInvoiceOwner(invoiceOwner);
    }

    public Invoice getInvoiceByInvoiceNumber(int invoiceNumber) {
        return invoiceRepository.findByInvoiceNumber(invoiceNumber);
    }

    public List<Invoice> getInvoiceByPaidInvoice(boolean paidInvoice) {
        return invoiceRepository.findByPaidInvoice(paidInvoice);
    }
}
