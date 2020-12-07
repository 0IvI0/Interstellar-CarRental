import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Car } from 'src/app/models/Car';
import { CarService } from 'src/app/services/car.service';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {

  carList: Car[];
  availability: string;
  searchText: string = '';

  constructor(private carService: CarService, private router: Router) {
   }

  ngOnInit(): void {
    this.carService.getCarList().subscribe(carList => {
      this.carList = carList;
    });
  }


  checkAvailability(): void {
    for (let entry of this.carList) {
      this.availability = (entry.availableForRent) ? 'Available' : 'Not available';
    }
  }


  goToCarDetails(car: Car): void {
    this.router.navigate(['cardetails/' + car.vehicleID]);
  }

  gotToOrderProcessingPage(): void {
    this.router.navigate(['order-processing']);
  }

  goToRentConfirmPage(): void {
    
  }

}
