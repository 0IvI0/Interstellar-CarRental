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
  carCreateUrl: string = 'api/employee/addCar';
  carDeleteUrl: string = '/employee/deleteCar';
  carLimit = '?_limit=8';

  constructor(private http: HttpClient) { }


  getCarList(): Observable<Car[]> {
    return this.http.get<Car[]>(this.carListUrl);
  }


  //  URL to backend:     /api/cardetail/GTR5643D
  getCar(vehicleID: string): Observable<Car> {
    return this.http.get<Car>(this.carDetailUrl + '/' + vehicleID);
  }


  createCar(carData: Car): Observable<any> {
    return this.http.post(this.carCreateUrl, carData);
  }


/*   updateCar(vehicleID: string, car: Car): Observable<any> {
    return this.http.put(`${}`)     // TO DO: add api url
  } */


  deleteCar(vehicleID: string): Observable<any> {
      return this.http.delete(`${this.carDeleteUrl}/${vehicleID}`);
  }

}
