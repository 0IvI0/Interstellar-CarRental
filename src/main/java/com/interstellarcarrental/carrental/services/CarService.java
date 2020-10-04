package com.interstellarcarrental.carrental.services;

import java.util.List;

import com.interstellarcarrental.carrental.models.Car;
import com.interstellarcarrental.carrental.repositories.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarService {

    static final String NOTFOUND_MESSAGE = "Item (car) not found.";

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


    //DELETE method:

    public String deleteCarById(long id) {
        if (!carRepository.findById(id).isPresent()) {
            return "No item found with the provided ID.";
        }
        String vehicleID = carRepository.findById(id).get().getVehicleID();
        carRepository.deleteById(id);
        return "Item with ID: " + id + " successfully deleted! Vehicle ID: " + vehicleID;
    }


    //PUT method:

    public String updateKilometerReading(Car car, double newKilometerReading) {
        if (carRepository.findById(car.getId()).isPresent()) {
        carRepository.findById(car.getId()).get().setKilometerReading(newKilometerReading);
        return "Kilometer reading successfully changed! ID: " + car.getId();
        }
        return NOTFOUND_MESSAGE;
    }

    public String clearKilometerReading(Car car) {
        if (carRepository.findById(car.getId()).isPresent()) {
            carRepository.findById(car.getId()).get().setKilometerReading(0.0);
            carRepository.findById(car.getId()).get().setKilometerReadingCleared(true);
            return "Kilometer reading has been cleared.";
        }
        return NOTFOUND_MESSAGE;
    }

    public String updateAvailabilityForRent(Car car, boolean availableForRent) {
        if (carRepository.findById(car.getId()).isPresent()) {
            carRepository.findById(car.getId()).get().setAvailableForRent(availableForRent);
            String availability;
            if (availableForRent) {
                availability = "Available for rent";
            } else {
                availability = "Not available for rent.";
            }
            return "Availability for Rent has been changed. Status: " + availability;
        }
        return NOTFOUND_MESSAGE;
    }

    public String updateBasicPrice(Car car, double newBasicPrice) {
        if (carRepository.findById(car.getId()).isPresent()) {
            carRepository.findById(car.getId()).get().setBasicPrice(newBasicPrice);
            return "Basic price has been set for the car with the ID " + car.getId() + " . Current basic price: " + car.getBasicPrice() + " Euro";
        }
        return NOTFOUND_MESSAGE;
    }
}
