package com.interstellarcarrental.carrental.dto;

import com.interstellarcarrental.carrental.models.User;

import lombok.Data;


@Data
public class CarDTO {

    private String vehicleID;
    private User currentlyRentedBy;
    private String imgURL;
    private String modelName;
    private String manufacturingDate;
    private String propellantType;
    private double kilometerReading;
    private boolean kilometerReadingCleared = false;
    private double basicPrice;
    private String description;
    private boolean availableForRent;
    private int seatNumber;
    private String seatCover;
    private String color;
    private boolean navigationSystem;
    private boolean autoPilot;
    private boolean temperatureControlSystem;
    private boolean safetySystem;
    private boolean storageCabinet;

    public void clearKilometerReading() {
        kilometerReading = 0.0;
        kilometerReadingCleared = true;
    }
}