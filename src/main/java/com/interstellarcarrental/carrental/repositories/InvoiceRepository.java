package com.interstellarcarrental.carrental.repositories;

import com.interstellarcarrental.carrental.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
}
