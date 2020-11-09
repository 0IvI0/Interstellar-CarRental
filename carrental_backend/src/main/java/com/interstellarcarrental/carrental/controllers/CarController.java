package com.interstellarcarrental.carrental.controllers;

import java.util.List;

import com.interstellarcarrental.carrental.dto.CarDTO;
import com.interstellarcarrental.carrental.services.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CarController {
    
    @Autowired
    private CarService carService;


    //POST MAPPING

    @PostMapping("/employee/addCar")
    public String saveCar(CarDTO carDto) {
        carService.saveCar(carDto);
        return "The car has been added successfully.";
    }

    
    //GET MAPPING

    @GetMapping("/api/listCars")
    public List<CarDTO> listCars() {
        return carService.getCars();
    }

    @GetMapping("/api/listCars/{model}")
    public List<CarDTO> listCarsMatchingModelName(@PathVariable String model) {
        return carService.getCarsByModelName(model);
    }

    @GetMapping("/api/listCars/{kmReadingCleared}")
    public List<CarDTO> listCarsWithClearedKilometerReading(@PathVariable boolean kmReadingCleared) {
        return carService.getCarByKilometerReadingCleared(kmReadingCleared);
    }

    @GetMapping("/api/listCars/{basicPrice}")
    public List<CarDTO> listCarsByBasicPrice(@PathVariable double basicPrice) {
        return carService.getCarByBasicPrice(basicPrice);
    }

    @GetMapping("/api/listCars/{availability}")
    public List<CarDTO> listCarsAvailableForRent(@PathVariable boolean availability) {
        return carService.getCarByAvailableForRent(availability);
    }

    @GetMapping("/api/listCars/{seatNumber}")
    public List<CarDTO> listCarsMatchingSeatNumber(@PathVariable int seatNumber) {
        return carService.getCarBySeatNumber(seatNumber);
    }

    //Only for employee:
    @GetMapping("/api/employee/listCars/{vehicleId}")
    public CarDTO getCarByVehicleId(@PathVariable String vehicleId) {
            return carService.getCarByVehicleID(vehicleId);
    }
}