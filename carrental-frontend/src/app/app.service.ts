import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Customer } from './models/Customer';
import { Router } from '@angular/router';


@Injectable({
    providedIn: 'root'
})
export class AppService {

    sessionUser = new BehaviorSubject<Customer|null>(null);

    constructor(private http: HttpClient, private router: Router) {
        this.http.get<Customer>('/api/sessionUser').subscribe(u => this.sessionUser.next(u));
    }

    public getSessionUser(): Observable<Customer|null> {
        return this.sessionUser;
      }


    public login(username: string, password: string) {
    this.http.get<Customer>('/api/sessionUser', {
      headers: {
        authorization: 'Basic ' + btoa(username + ':' + password)
      }
    }).subscribe(
      u => {
        this.sessionUser.next(u);
        if (u != null) {
          // wir sind eingeloggt
          if (u.userRole == "EMPLOYEE") {
            console.log('Hi, I am an employee.');
            //this.router.navigate(['employee']);
          } else {
            console.log('I am a customer.');
            //this.router.navigate(['customer']);
          }
        }
      },
      () => this.sessionUser.next(null),
    );
  }  


  public logout() {
    this.http.post('/api/logout', null).subscribe(
      () => {
        this.router.navigate(['/']);
        this.sessionUser.next(null);
      }
    );
  }


  public register(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>('/api/register', customer);
  }

}