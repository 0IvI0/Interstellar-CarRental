package com.interstellarcarrental.carrental.models;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class InvoiceItems {
    
    //private int amount;
    private Car rentalCar;

    InvoiceItems(final Car rentalCar) {
        this.setRentalCar(rentalCar);
    }

    double calculateRentalPrice() {
        return this.getRentalCar().getBasicPrice() + calculatePriceProKilometer();
    }

    double calculatePriceProKilometer() {
        return this.getRentalCar().getKilometerReading() * 1.5;
    }
}
