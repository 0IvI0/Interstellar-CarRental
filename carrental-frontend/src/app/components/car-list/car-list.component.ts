import { Component, OnInit } from '@angular/core';
import { Car } from 'src/app/models/Car';
import { CarService } from 'src/app/services/car.service';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {

  carList: Car[];

  constructor(private carService: CarService) {
   }

  ngOnInit(): void {
    this.carService.getCarList().subscribe(carList => {
      this.carList = carList;
    });
  }

}
