package com.interstellarcarrental.carrental.services;

import java.util.List;

import com.interstellarcarrental.carrental.dto.CarDTO;
import com.interstellarcarrental.carrental.dto.DTOconverter;
import com.interstellarcarrental.carrental.models.Car;
import com.interstellarcarrental.carrental.models.User;
import com.interstellarcarrental.carrental.repositories.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarService {

    static final String NOTFOUND_MESSAGE = "Item (car) not found.";

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DTOconverter dtoConverter;


//POST method:

    public Car saveCar(CarDTO carDto) {
        return carRepository.save(dtoConverter.carDTOtoEntity(carDto));
    }

    public List<Car> saveCars(List<CarDTO> carsDto) {
        return carRepository.saveAll(dtoConverter.carListDTOtoEntity(carsDto));
    }


//GET method:

    public List<CarDTO> getCars() {
        return dtoConverter.carListEntityToDTO(carRepository.findAll());
    }

/*     public Car getCarById(long id) {
        return carRepository.findById(id).orElse(null);
    }
*/
    public CarDTO getCarByVehicleID(String vehicleID) {
        return dtoConverter.carEntityToDTO(carRepository.findByVehicleIDIgnoreCase(vehicleID));
    }

    public List<CarDTO> getCarsByModelName(String modelName) {
        return dtoConverter.carListEntityToDTO(carRepository.findByModelNameIgnoreCase(modelName));
    }

    public List<CarDTO> getCarByKilometerReadingCleared(boolean kilometerReadingCleared) {
        return dtoConverter.carListEntityToDTO(carRepository.findByKilometerReadingCleared(kilometerReadingCleared));
    }

    public List<CarDTO> getCarByBasicPrice(double basicPrice) {
        return dtoConverter.carListEntityToDTO(carRepository.findByBasicPrice(basicPrice));
    }

    public List<CarDTO> getCarByAvailableForRent(boolean availableForRent) {
        return dtoConverter.carListEntityToDTO(carRepository.findByAvailableForRent(availableForRent));
    }

    public List<CarDTO> getCarBySeatNumber(int seatNumber) {
        return dtoConverter.carListEntityToDTO(carRepository.findBySeatNumber(seatNumber));
    }

    public List<CarDTO> getCarByCurrentRenter(User renter) {
        return dtoConverter.carListEntityToDTO(carRepository.findByCurrentRenter(renter));
    }


    //DELETE method:

    public String deleteCarByVehicleId(String vehicleId) {
        if (carRepository.findByVehicleIDIgnoreCase(vehicleId) == null) {
            return "No item found with the provided Vehicle ID.";
        }
        long id = carRepository.findByVehicleIDIgnoreCase(vehicleId).getId();
        carRepository.deleteById(id);
        return "Item with ID: " + id + " successfully deleted! Vehicle ID: " + vehicleId;
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
