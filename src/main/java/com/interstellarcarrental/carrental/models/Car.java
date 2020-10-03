package com.interstellarcarrental.carrental.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CAR")
public class Car {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String vehicleID;
    private String modelName;
    private String manufacturingDate;
    private String propellantType;
    private double kilometerReading;
    private boolean kilometerReadingCleared;
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
