import { HttpClient } from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppService } from 'src/app/app.service';
import { Customer } from 'src/app/models/Customer';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

@Injectable()
export class RegisterComponent implements OnInit {

  
  formRegister = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });

  sessionUser: Customer | null = null;

  newCustomer: Customer;

  constructor(private http: HttpClient, private app: AppService, private router: Router) {
  }


  onSubmit() {

    if (this.formRegister.invalid) {
      return;
    }

    this.newCustomer = new Customer(this.formRegister.value);

    this.app.register(this.newCustomer)
        .pipe() //pipe(first())
        .subscribe({
          next: () => {
            this.router.navigate(['/home']);}
          });
  }

  ngOnInit() {
    this.app.getSessionUser().subscribe(u => this.sessionUser = u);
  }
}