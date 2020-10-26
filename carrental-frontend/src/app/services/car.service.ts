import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Car } from 'src/app/models/Car';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CarService {

  carListUrl : string = 'https://localhost:8080/listCars';

  constructor(private http:HttpClient) { }


  getCarList():Observable<Car[]> {
    return this.http.get<Car[]>(this.carListUrl);
  }

}
