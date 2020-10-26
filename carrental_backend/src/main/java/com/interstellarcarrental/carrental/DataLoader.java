package com.interstellarcarrental.carrental;

import com.interstellarcarrental.carrental.models.Car;
import com.interstellarcarrental.carrental.repositories.CarRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
    
    private final CarRepository carRepo;

    public DataLoader(CarRepository carRepo) {
        this.carRepo = carRepo;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    // First Car object:
        Car car1 = new Car();
		car1.setVehicleID("GTR5643D");
		car1.setAutoPilot(true);
		car1.setAvailableForRent(true);
		car1.setBasicPrice(200.0);
		car1.setColor("silver");
		car1.setDescription("Second example text.");
		car1.setImgURL("imgURL");
		car1.setKilometerReading(100.0);
		car1.setKilometerReadingCleared(false);
		car1.setManufacturingDate("2078");
		car1.setModelName("Jupiterfly1000");
		car1.setNavigationSystem(true);
		car1.setNumberOfAvailableCars(1);
		car1.setPropellantType("fuel");
		car1.setSafetySystem(true);
		car1.setSeatCover("leather");
		car1.setSeatNumber(8);
		car1.setStorageCabinet(true);
		car1.setTemperatureControlSystem(true);
        car1.setValueAddedTax(10.0);
        
        carRepo.save(car1);


    // Second Car object:
        Car car2 = new Car();
		car2.setVehicleID("SF3OGOT4");
		car2.setAutoPilot(true);
		car2.setAvailableForRent(true);
		car2.setBasicPrice(100.0);
		car2.setColor("gold");
		car2.setDescription("Example text.");
		car2.setImgURL("imgURL");
		car2.setKilometerReading(100.0);
		car2.setKilometerReadingCleared(false);
		car2.setManufacturingDate("2078");
		car2.setModelName("Saturnsfly1000");
		car2.setNavigationSystem(true);
		car2.setNumberOfAvailableCars(1);
		car2.setPropellantType("fuel");
		car2.setSafetySystem(true);
		car2.setSeatCover("leather");
		car2.setSeatNumber(8);
		car2.setStorageCabinet(true);
		car2.setTemperatureControlSystem(true);
        car2.setValueAddedTax(10.0);
        
        carRepo.save(car2);


    // Third Car object:
        Car car3 = new Car();
		car3.setVehicleID("DFIDFGOR");
		car3.setAutoPilot(true);
		car3.setAvailableForRent(true);
		car3.setBasicPrice(150.0);
		car3.setColor("metalblue");
		car3.setDescription("Third example text.");
		car3.setImgURL("imgURL");
		car3.setKilometerReading(100.0);
		car3.setKilometerReadingCleared(false);
		car3.setManufacturingDate("2078");
		car3.setModelName("Venusfly1000");
		car3.setNavigationSystem(true);
		car3.setNumberOfAvailableCars(1);
		car3.setPropellantType("fuel");
		car3.setSafetySystem(true);
		car3.setSeatCover("leather");
		car3.setSeatNumber(8);
		car3.setStorageCabinet(true);
		car3.setTemperatureControlSystem(true);
        car3.setValueAddedTax(10.0);
        
        carRepo.save(car3);
    }
}
