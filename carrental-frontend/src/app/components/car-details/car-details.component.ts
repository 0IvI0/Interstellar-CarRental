import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Car } from 'src/app/models/Car';
import { CarService } from 'src/app/services/car.service'; 

@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.css']
})
export class CarDetailsComponent implements OnInit {

  @Input() car: Car;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private carService: CarService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.getCar();
  }


  getCar(): void {
    const vehicleID = this.route.snapshot.paramMap.get('vehicleID');
    this.carService.getCar(vehicleID)
      .subscribe(car => this.car = car);
  }


  goToOrderProcessingPage(): void {
    this.router.navigate(['order-processing']);
  }

  goToRentConfirmPage(): void {

  }


  goBackToCarList(): void {
    this.location.back();
  }
}