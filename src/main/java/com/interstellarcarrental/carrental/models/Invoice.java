package com.interstellarcarrental.carrental.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Setter
@Getter
@Entity
@Table(name = "Invoice")
public class Invoice {

    static int nextInvoiceNumber = 10000;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private double discount;
    private Customer invoiceOwner;
    private boolean paidInvoice = false;
    private List<InvoiceItems> invoiceItems = new LinkedList<>();
    private final int invoiceNumber;

    public Invoice(final Customer invoiceOwner) {
        this.invoiceOwner = invoiceOwner;
        this.invoiceNumber = Invoice.calculateNextInvoiceNumber();
    }

    private static int calculateNextInvoiceNumber() {
        return Invoice.nextInvoiceNumber++;
    }


    void addInvoiceItems(InvoiceItems item) {
        this.invoiceItems.add(item);
    }

    double calculateNetPrice(){
        double sum = 0;
        for (InvoiceItems item : invoiceItems) {
            sum += item.calculateRentalPrice();
        }
        return sum * (1 - this.getDiscount());
    }


    double calculateValueAddedTax() {
        double sum = 0;
        for (InvoiceItems item : invoiceItems) {
            sum += item.calculateRentalPrice() * item.getRentalCar().getValueAddedTax();
        }
        return sum * (1 - this.getDiscount());
    }


    double calculateGrossPrice() {
        return this.calculateNetPrice() + calculateValueAddedTax();
    }

    
    
    void printInvoice() {
        printInvoice(new PrintWriter(System.out));
    }

    
    private void printInvoice(PrintWriter pw) {
        pw.println("_____________INVOICE_______________");
        pw.println("____________created by_____________");
        pw.println("____Interstellar CarRental Ltd.____");
        pw.println("");
        pw.println("Invoice nr. " + this.invoiceNumber);
        pw.print("To:  ");
        pw.println(this.getInvoiceOwner().getUsersName());
        pw.println("     " + this.getInvoiceOwner().getAddress());
        pw.println("");
        pw.println("Rental car:");
        for (InvoiceItems item : invoiceItems) {
            pw.println("Vehicle Identification Number (VIN): " + item.getRentalCar().getVehicleID());
            pw.println("Model name: " + item.getRentalCar().getModelName());
        }
        pw.println("");
        pw.println("Rent price (Net price): " + this.calculateNetPrice());
        pw.println("VAT: " + this.calculateValueAddedTax());
        pw.println("Gross price (to be payed by the customer): " + this.calculateGrossPrice());
        pw.flush();
    }


    void saveInvoice() {
        File file = new File(invoiceNumber + ".txt");
        if (file.exists()) {
            log.info("Invoice already exists. Thus the invoice with this invoice number cannot be saved. For further assistance, please call the Technical Support Service.");
        }
        PrintWriter pw;
        try {
            pw = new PrintWriter(file);
            printInvoice(pw);
            pw.close();
        } catch (FileNotFoundException e) {
            log.info("Invoice file cannot be found. Thus the invoice cannot be saved. For further assistance, please call the Technical Support Service.");
        }
    }
}

