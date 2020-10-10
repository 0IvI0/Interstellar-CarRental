package com.interstellarcarrental.carrental.repositories;

import java.util.List;

import com.interstellarcarrental.carrental.models.Car;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<Car, Long> {
    
    Car findByVehicleIDIgnoreCase(String vehicleID);
    List<Car> findByModelNameIgnoreCase(String modelName);
    List<Car> findByKilometerReadingCleared(Boolean kilometerReadingCleared);
    List<Car> findByBasicPrice(Double basicPrice);
    List<Car> findByAvailableForRent(Boolean availableForRent);
    List<Car> findBySeatNumber(Integer seatNumber);
}
