import { Component, OnInit } from '@angular/core';
import { Car } from 'src/app/models/Car';
import { CarService } from 'src/app/services/car.service';

@Component({
  selector: 'app-car-create',
  templateUrl: './car-create.component.html',
  styleUrls: ['./car-create.component.css']
})
export class CarCreateComponent implements OnInit {

    car: Car = {
        vehicleID: '',
        imgURL: '',
        modelName: '',
        manufacturingDate: '',
        propellantType: '',
        kilometerReading: 0.0,
        kilometerReadingCleared: true,
        basicPrice: 0.0,
        description: '',
        availableForRent: true,
        seatNumber: 0,
        seatCover: '',
        color: '',
        navigationSystem: true,
        autoPilot: true,
        temperatureControlSystem: true,
        safetySystem: true,
        storageCabinet: true,
    };

    submitted: boolean = false;

  constructor(private carService: CarService) { }

  ngOnInit(): void {
  }


createCar(): void {
    const carData = {
        vehicleID: this.car.vehicleID,
        imgURL: this.car.imgURL,
        modelName: this.car.modelName,
        manufacturingDate: this.car.manufacturingDate,
        propellantType: this.car.propellantType,
        kilometerReading: this.car.kilometerReading,
        kilometerReadingCleared: this.car.kilometerReadingCleared, 
        basicPrice: this.car.basicPrice,
        description: this.car.description,
        availableForRent: this.car.availableForRent,
        seatNumber: this.car.seatNumber,
        seatCover: this.car.seatCover,
        color: this.car.color,
        navigationSystem: this.car.navigationSystem,
        autoPilot: this.car.autoPilot,
        temperatureControlSystem: this.car.temperatureControlSystem,
        safetySystem: this.car.safetySystem,
        storageCabinet: this.car.storageCabinet
    };

    this.carService.createCar(carData)
        .subscribe(
            response => {
                console.log('Submitted new Car.');
                this.submitted = true;
            },
            error => {
                console.log('Error by submitting new Car.');
            }
        );
}

newCar(): void {
    this.submitted = false;
    this.car = {
        vehicleID: '',
        imgURL: '',
        modelName: '',
        manufacturingDate: '',
        propellantType: '',
        kilometerReading: 0.0,
        kilometerReadingCleared: true,
        basicPrice: 0.0,
        description: '',
        availableForRent: true,
        seatNumber: 0.0,
        seatCover: '',
        color: '',
        navigationSystem: true,
        autoPilot: true,
        temperatureControlSystem: true,
        safetySystem: true,
        storageCabinet: true
    };
  }
}