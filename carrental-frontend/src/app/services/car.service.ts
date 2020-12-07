import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Car } from 'src/app/models/Car';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root',
})
export class CarService {

  carListUrl: string = '/api/listCars';
  carDetailUrl: string = '/api/cardetail';
  carLimit = '?_limit=8';

  constructor(private http: HttpClient) { }


  getCarList(): Observable<Car[]> {
    return this.http.get<Car[]>(this.carListUrl);
  }


  //  URL to backend:     /api/cardetail/GTR5643D

  getCar(vehicleID: string): Observable<Car> {
    return this.http.get<Car>(this.carDetailUrl + '/' + vehicleID);
  }

}
