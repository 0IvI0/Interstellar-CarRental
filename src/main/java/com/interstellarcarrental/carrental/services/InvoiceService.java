package com.interstellarcarrental.carrental.services;

import java.util.List;

import com.interstellarcarrental.carrental.models.Customer;
import com.interstellarcarrental.carrental.models.Invoice;
import com.interstellarcarrental.carrental.repositories.InvoiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InvoiceService {

    static final String NOTFOUND_MESSAGE = "Invoice not found.";

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


    //DELETE method:

    public String deleteInvoiceById(long id) {
        if (!invoiceRepository.findById(id).isPresent()) {
            return "No item found with the provided ID.";
        }
        if (invoiceRepository.findById(id).get().getInvoiceOwner().equals(null)) {
            invoiceRepository.deleteById(id);
            return "Invoice with the ID " + id + " has been deleted.";
        }
        return "The invoice with the ID " + id + " cannot be deleted because it belongs to the customer: " + invoiceRepository.findById(id).get().getInvoiceOwner().getId();
    }


    //PUT method:
    
    public String updateDiscount(Invoice invoice, double newDiscount) {
        if (invoiceRepository.findById(invoice.getId()).isPresent()) {
        invoiceRepository.findById(invoice.getId()).get().setDiscount(newDiscount);
        return "The following discount has been added to the invoice with the ID " + invoice.getId() + " and the invoice number " + invoice.getInvoiceNumber() + ": " + invoice.getDiscount() + " %";
        }
        return NOTFOUND_MESSAGE;
    }
}
