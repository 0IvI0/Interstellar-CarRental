package com.interstellarcarrental.carrental.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "CAR")
public class Car implements Serializable {

    private static final long serialVersionUID = 2978234905360017238L;

    @Column(name = "CAR_PRIM_KEY", nullable = false, unique = true)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "VEHICLE_ID", nullable = false, unique = true)
    private String vehicleID;

    @Column(name = "IMG_URL")
    private String imgURL;

    @Column(name = "CAR_MODEL", nullable = false)
    private String modelName;

    @Column(name = "MANUFACT_DATE", nullable = false)
    private String manufacturingDate;

    @Column(name = "PROPELLANT", nullable = false)
    private String propellantType;

    @Column(name = "KM_READING", nullable = false)
    private double kilometerReading;

    @Column(name = "IF_KM_READING_CLEARED", nullable = false)
    private boolean kilometerReadingCleared = false;

    @Column(name = "PRICE_BASIC", nullable = false)
    private double basicPrice;

    @Column(name = "VAT", nullable = false)
    private double valueAddedTax;

    @Column(name = "IF_AVAILABLE", nullable = false)
    private boolean availableForRent;

    @ManyToOne
    @JoinColumn(name = "USER_PRIM_KEY")
    private User currentlyRentedBy;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "SEAT_NR", nullable = false)
    private int seatNumber;

    @Column(name = "SEAT_COVER", nullable = false)
    private String seatCover;

    @Column(name = "COLOR", nullable = false)
    private String color;

    @Column(name = "HAS_NAV_SYSTEM", nullable = false)
    private boolean navigationSystem;

    @Column(name = "HAS_AUTOPILOT", nullable = false)
    private boolean autoPilot;

    @Column(name = "HAS_TEMPERATURE_CONTROL", nullable = false)
    private boolean temperatureControlSystem;

    @Column(name = "HAS_SAFETY_SYSTEM", nullable = false)
    private boolean safetySystem;

    @Column(name = "HAS_STORAGE_CABINET", nullable = false)
    private boolean storageCabinet;



    public void clearKilometerReading() {
        kilometerReading = 0.0;
        kilometerReadingCleared = true;
    }
}