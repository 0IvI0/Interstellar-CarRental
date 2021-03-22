package com.interstellarcarrental.carrental.dto;

/* import java.util.LinkedList;
import java.util.List; */

//import com.interstellarcarrental.carrental.models.InvoiceItems;
import com.interstellarcarrental.carrental.models.User;

import lombok.Data;

@Data
public class InvoiceDTO {
    
    private double discount;
    private User invoiceOwner;
    private boolean paidInvoice = false;
    //private List<InvoiceItems> invoiceItems = new LinkedList<>();


    public InvoiceDTO(final User invoiceOwner) {
        this.invoiceOwner = invoiceOwner;
    }
}