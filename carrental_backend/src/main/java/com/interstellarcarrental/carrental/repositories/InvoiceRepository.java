package com.interstellarcarrental.carrental.repositories;

import java.util.List;

import com.interstellarcarrental.carrental.models.Invoice;
import com.interstellarcarrental.carrental.models.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
    List<Invoice> findByInvoiceOwner(User invoiceOwner);
    List<Invoice> findByPaidInvoice(Boolean paidInvoice);
    Invoice findByInvoiceNumber(Integer invoiceNumber);
}