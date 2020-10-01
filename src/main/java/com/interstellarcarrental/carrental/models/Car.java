package com.interstellarcarrental.carrental.models;

import lombok.Data;

@Data
public class Car {
    
    private long id;
    private String modelName;
    private String manufacturingDate;
    private String propellantType;
    private double kilometerReading;
    private double basicPrice;
    private double valueAddedTax;
    private String description;
    private boolean availableForRent;
    private int numberOfAvailableCars;
    private int seatNumber;
    private String seatCover;
    private String color;
    private boolean navigationSystem;
    private boolean autoPilot;
    private boolean temperatureControlSystem;
    private boolean safetySystem;
    private boolean storageCabinet;
}
