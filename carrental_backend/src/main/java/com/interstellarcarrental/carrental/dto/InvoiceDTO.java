package com.interstellarcarrental.carrental.dto;

/* import java.util.LinkedList;
import java.util.List; */

import com.interstellarcarrental.carrental.models.Customer;
//import com.interstellarcarrental.carrental.models.InvoiceItems;

import lombok.Data;

@Data
public class InvoiceDTO {
    
    private double discount;
    private Customer invoiceOwner;
    private boolean paidInvoice = false;
    //private List<InvoiceItems> invoiceItems = new LinkedList<>();
}
