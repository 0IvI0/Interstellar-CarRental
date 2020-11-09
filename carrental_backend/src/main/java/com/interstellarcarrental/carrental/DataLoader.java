package com.interstellarcarrental.carrental;

import java.time.LocalDate;

import com.interstellarcarrental.carrental.models.Car;
import com.interstellarcarrental.carrental.models.Customer;
import com.interstellarcarrental.carrental.models.Employee;
import com.interstellarcarrental.carrental.repositories.CarRepository;
import com.interstellarcarrental.carrental.repositories.CustomerRepository;
import com.interstellarcarrental.carrental.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
    
	private final CarRepository carRepo;
	private final CustomerRepository custRepo;
	private final EmployeeRepository employeeRepo;

	@Autowired
	private PasswordEncoder pwEncoder;

    public DataLoader(CarRepository carRepo, CustomerRepository custRepo, EmployeeRepository employeeRepo) {
		this.carRepo = carRepo;
		this.custRepo = custRepo;
		this.employeeRepo = employeeRepo;
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



	// First Customer object:
		Customer cust1 = new Customer();
		cust1.setAddress("Baker Street 12.");
		cust1.setBirthDate(LocalDate.of(1978, 01, 23));
		cust1.setCreditCardNumber("DFG3445FGDFH");
		cust1.setEmailAddress("email@address");
		cust1.setFirstName("John");
		cust1.setLastName("Doe");
		cust1.setUsername("Jd007");
		cust1.setPassword(pwEncoder.encode("secretPassword"));
		cust1.setPhoneNumber("+23434345");

		custRepo.save(cust1);


	// First Employee object:
		Employee employee1 = new Employee();
		employee1.setAddress("NewYork Street 12.");
		employee1.setBirthDate(LocalDate.of(1963, 03, 12));
		employee1.setCreditCardNumber("DFG3FG87545");
		employee1.setEmailAddress("email2@address");
		employee1.setFirstName("Jane");
		employee1.setLastName("McDonald");
		employee1.setUsername("TheEmployEE");
		employee1.setPassword(pwEncoder.encode("empPassword"));
		employee1.setPhoneNumber("+547678767");

		employeeRepo.save(employee1);
	}
}