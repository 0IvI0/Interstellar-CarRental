/* package com.interstellarcarrental.carrental;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.interstellarcarrental.carrental.app_constants.RoleConstants;
import com.interstellarcarrental.carrental.models.Car;
import com.interstellarcarrental.carrental.models.Customer;
import com.interstellarcarrental.carrental.models.Employee;
import com.interstellarcarrental.carrental.models.Role;
import com.interstellarcarrental.carrental.repositories.CarRepository;
import com.interstellarcarrental.carrental.repositories.CustomerRepository;
import com.interstellarcarrental.carrental.repositories.EmployeeRepository;
import com.interstellarcarrental.carrental.repositories.RoleRepository;

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
    private final RoleRepository roleRepo;

	@Autowired
	private PasswordEncoder pwEncoder;

    public DataLoader(CarRepository carRepo, CustomerRepository custRepo, EmployeeRepository employeeRepo, RoleRepository roleRepo) {
		this.carRepo = carRepo;
		this.custRepo = custRepo;
		this.employeeRepo = employeeRepo;
        this.roleRepo = roleRepo;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    // First Car object:
        Car car1 = new Car();
		car1.setVehicleID("G007M1000");
		car1.setAutoPilot(true);
		car1.setAvailableForRent(true);
		car1.setBasicPrice(200.0);
		car1.setColor("blue");
		car1.setDescription("Second example text.");
		car1.setImgURL("carrental-frontend\\src\\assets\\images\\productImages\\shipImg.png");
		car1.setKilometerReading(100.0);
		car1.setKilometerReadingCleared(false);
		car1.setManufacturingDate("2078");
		car1.setModelName("Moonlight800");
		car1.setNavigationSystem(true);
		//car1.setNumberOfAvailableCars(1);
		car1.setPropellantType("fuel");
		car1.setSafetySystem(true);
		car1.setSeatCover("leather");
		car1.setSeatNumber(8);
		car1.setStorageCabinet(true);
		car1.setTemperatureControlSystem(true);
        
        carRepo.save(car1);


    // Second Car object:
        Car car2 = new Car();
		car2.setVehicleID("RF4DGO8G");
		car2.setAutoPilot(true);
		car2.setAvailableForRent(true);
		car2.setBasicPrice(100.0);
		car2.setColor("black");
		car2.setDescription("Example text.");
		car2.setImgURL("carrental-frontend\\src\\assets\\images\\productImages\\shipImg.png");
		car2.setKilometerReading(100.0);
		car2.setKilometerReadingCleared(false);
		car2.setManufacturingDate("2078");
		car2.setModelName("Nebulalight700");
		car2.setNavigationSystem(true);
		//car2.setNumberOfAvailableCars(1);
		car2.setPropellantType("fuel");
		car2.setSafetySystem(true);
		car2.setSeatCover("leather");
		car2.setSeatNumber(8);
		car2.setStorageCabinet(true);
		car2.setTemperatureControlSystem(true);
        
        carRepo.save(car2);


    // Third Car object:
        Car car3 = new Car();
		car3.setVehicleID("K845DFG7T");
		car3.setAutoPilot(true);
		car3.setAvailableForRent(true);
		car3.setBasicPrice(150.0);
		car3.setColor("metalgreen");
		car3.setDescription("Third example text.");
		car3.setImgURL("carrental-frontend\\src\\assets\\images\\productImages\\shipImg.png");
		car3.setKilometerReading(100.0);
		car3.setKilometerReadingCleared(false);
		car3.setManufacturingDate("2078");
		car3.setModelName("MarsExplorer1000");
		car3.setNavigationSystem(true);
		//car3.setNumberOfAvailableCars(1);
		car3.setPropellantType("fuel");
		car3.setSafetySystem(true);
		car3.setSeatCover("leather");
		car3.setSeatNumber(8);
		car3.setStorageCabinet(true);
		car3.setTemperatureControlSystem(true);
        
		carRepo.save(car3);

	
	// Fourth Car object:
        Car car4 = new Car();
		car4.setVehicleID("LK52S567DG");
		car4.setAutoPilot(true);
		car4.setAvailableForRent(false);
		car4.setBasicPrice(160.0);
		car4.setColor("yellow");
		car4.setDescription("Fourth example text.");
		car4.setImgURL("carrental-frontend\\src\\assets\\images\\productImages\\shipImg.png");
		car4.setKilometerReading(100.0);
		car4.setKilometerReadingCleared(false);
		car4.setManufacturingDate("2078");
		car4.setModelName("Starlight900");
		car4.setNavigationSystem(true);
		//car4.setNumberOfAvailableCars(1);
		car4.setPropellantType("fuel");
		car4.setSafetySystem(true);
		car4.setSeatCover("leather");
		car4.setSeatNumber(8);
		car4.setStorageCabinet(true);
		car4.setTemperatureControlSystem(true);
        
		carRepo.save(car4);


	// Two role objects:
        Role employeeRole = new Role(RoleConstants.ROLE_EMPLOYEE, RoleConstants.ROLE_EMPL_DESCRIPTION);
        Role customerRole = new Role(RoleConstants.ROLE_CUSTOMER, RoleConstants.ROLE_CUST_DESCRIPTION);

        roleRepo.save(employeeRole);
        roleRepo.save(customerRole);


	// First Customer object:
		Customer cust1 = new Customer();
		cust1.setAddress("Baker Street 12.");
		cust1.setBirthDate(LocalDate.of(1978, 01, 23));
		cust1.setCreditCardNumber("BN12987432");
		cust1.setEmailAddress("emailcustomer@address");
		cust1.setFirstName("Jack");
		cust1.setLastName("Doe");
		cust1.setUsername("doe007");
		cust1.setPassword(pwEncoder.encode("customerPw"));
		cust1.setPhoneNumber("+23434345");
        Set<Role> custRoles = new HashSet<>();
        custRoles.add(roleRepo.findByRoleName(RoleConstants.ROLE_CUSTOMER));
        cust1.setRoles(custRoles);

		custRepo.save(cust1);


	// First Employee object:
		Employee employee1 = new Employee();
        employee1.setEmployeeNr("empID12345");
		employee1.setAddress("NewYork Street 12.");
		employee1.setBirthDate(LocalDate.of(1963, 03, 12));
		employee1.setCreditCardNumber("HOI7239546");
		employee1.setEmailAddress("emailemployee@address");
		employee1.setFirstName("Janet");
		employee1.setLastName("Jakil");
		employee1.setUsername("employee007");
		employee1.setPassword(pwEncoder.encode("employeePw"));
		employee1.setPhoneNumber("+547678767");
        Set<Role> emplRoles = new HashSet<>();
        emplRoles.add(roleRepo.findByRoleName(RoleConstants.ROLE_EMPLOYEE));
        employee1.setRoles(emplRoles);

		employeeRepo.save(employee1);
	}
} */