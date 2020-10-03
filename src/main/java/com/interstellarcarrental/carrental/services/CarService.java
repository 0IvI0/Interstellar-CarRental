package com.interstellarcarrental.carrental.services;

import java.util.List;

import com.interstellarcarrental.carrental.models.Car;
import com.interstellarcarrental.carrental.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;


//POST method:

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> saveCars(List<Car> cars) {
        return carRepository.saveAll(cars);
    }


//GET method:

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Car getCarById(long id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car getCarByVehicleID(String vehicleID) {
        return carRepository.findByVehicleIDIgnoreCase(vehicleID);
    }

    public List<Car> getCarByModelName(String modelName) {
        return carRepository.findByModelNameIgnoreCase(modelName);
    }

    public List<Car> getCarByKilometerReadingCleared(boolean kilometerReadingCleared) {
        return carRepository.findByKilometerReadingCleared(kilometerReadingCleared);
    }

    public List<Car> getCarByBasicPrice(double basicPrice) {
        return carRepository.findByBasicPrice(basicPrice);
    }

    public List<Car> getCarByAvailableForRent(boolean availableForRent) {
        return carRepository.findByAvailableForRent(availableForRent);
    }

    public List<Car> getCarBySeatNumber(int seatNumber) {
        return carRepository.findBySeatNumber(seatNumber);
    }

}
