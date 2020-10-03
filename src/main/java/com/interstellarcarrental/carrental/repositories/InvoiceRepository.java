package com.interstellarcarrental.carrental.repositories;

import java.util.List;

import com.interstellarcarrental.carrental.models.Customer;
import com.interstellarcarrental.carrental.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
    Invoice findByInvoiceOwner(Customer invoiceOwner);
    List<Invoice> findByPaidInvoice(Boolean paidInvoice);
    Invoice findByInvoiceNumber(Integer invoiceNumber);
}
