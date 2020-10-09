package com.interstellarcarrental.carrental.services;

import java.util.List;

import com.interstellarcarrental.carrental.dto.DTOconverter;
import com.interstellarcarrental.carrental.dto.InvoiceDTO;
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
    @Autowired
    private DTOconverter dtoConverter;


//POST method:    

    public Invoice saveInvoice(InvoiceDTO invoiceDto) {
        return invoiceRepository.save(dtoConverter.invoiceDTOtoEntity(invoiceDto));
    }

    public List<Invoice> saveInvoices(List<InvoiceDTO> invoicesDto) {
        return invoiceRepository.saveAll(dtoConverter.invoiceListDTOtoEntity(invoicesDto));
    }


//GET method:

    public List<InvoiceDTO> getInvoices() {
        return dtoConverter.invoiceListEntityToDTO(invoiceRepository.findAll());
    }

/*     public Invoice getInvoiceById(long id) {
        return invoiceRepository.findById(id).orElse(null);
    } */

    public List<InvoiceDTO> getInvoiceByInvoiceOwner(Customer invoiceOwner) {
        return dtoConverter.invoiceListEntityToDTO(invoiceRepository.findByInvoiceOwner(invoiceOwner));
    }

    public InvoiceDTO getInvoiceByInvoiceNumber(int invoiceNumber) {
        return dtoConverter.invoiceEntityToDTO(invoiceRepository.findByInvoiceNumber(invoiceNumber));
    }

    public List<InvoiceDTO> getInvoiceByPaidInvoice(boolean paidInvoice) {
        return dtoConverter.invoiceListEntityToDTO(invoiceRepository.findByPaidInvoice(paidInvoice));
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
