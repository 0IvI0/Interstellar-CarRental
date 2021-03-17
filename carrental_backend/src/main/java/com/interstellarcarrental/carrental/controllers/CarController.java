package com.interstellarcarrental.carrental.controllers;

import java.util.List;

import com.interstellarcarrental.carrental.dto.CarDTO;
import com.interstellarcarrental.carrental.models.User;
import com.interstellarcarrental.carrental.services.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CarController {
    
    @Autowired
    private CarService carService;


    // POST MAPPING

    // ONLY WITH ROLE: EMPLOYEE

    @PostMapping("/employee/addCar")
    public String saveCar(CarDTO carDto) {
        carService.saveCar(carDto);
        return "The car has been added successfully.";
    }


    // GET MAPPING
    
    // ONLY WITH ROLE: EMPLOYEE

    @GetMapping("/employee/listCars/{renter}")
    public List<CarDTO> listCarsByCurrentRenter(@PathVariable User renter) {
        return carService.getCarByCurrentRenter(renter);
    }

    
    // GET MAPPING

    // PUBLIC ENDPOINTS

    @GetMapping("/listCars")
    public List<CarDTO> listCars() {
        return carService.getCars();
    }

    @GetMapping("/listCars/{model}")
    public List<CarDTO> listCarsMatchingModelName(@PathVariable String model) {
        return carService.getCarsByModelName(model);
    }

    @GetMapping("/listCars/{kmReadingCleared}")
    public List<CarDTO> listCarsWithClearedKilometerReading(@PathVariable boolean kmReadingCleared) {
        return carService.getCarByKilometerReadingCleared(kmReadingCleared);
    }

    @GetMapping("/listCars/{basicPrice}")
    public List<CarDTO> listCarsByBasicPrice(@PathVariable double basicPrice) {
        return carService.getCarByBasicPrice(basicPrice);
    }

    @GetMapping("/listCars/{availability}")
    public List<CarDTO> listCarsAvailableForRent(@PathVariable boolean availability) {
        return carService.getCarByAvailableForRent(availability);
    }

    @GetMapping("/listCars/{seatNumber}")
    public List<CarDTO> listCarsMatchingSeatNumber(@PathVariable int seatNumber) {
        return carService.getCarBySeatNumber(seatNumber);
    }

    @GetMapping("/cardetail/{vehicleId}")
    public CarDTO getCarByVehicleId(@PathVariable String vehicleId) {
            return carService.getCarByVehicleID(vehicleId);
    }




    // DELETE MAPPING

    // ONLY WITH ROLE: EMPLOYEE

    @DeleteMapping("/employee/deleteCar{vehicleId}")
    public String deleteCar(@PathVariable String vehicleId) {
        carService.deleteCarByVehicleId(vehicleId);
        return "The car with the Vehicle ID " + vehicleId + " has been deleted successfully.";
    }
}