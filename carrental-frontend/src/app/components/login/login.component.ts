import { Component, Injectable, OnInit } from '@angular/core';
import { AppService } from '../../app.service';
import { Customer } from 'src/app/models/Customer';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

@Injectable()
export class LoginComponent implements OnInit {

    formLogin = new FormGroup({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });

    sessionUser: Customer | null = null;

    private loginCredentials = {username: '', password: ''};

    constructor(private app: AppService) {
  }


  onSubmit() {

    if (this.formLogin.invalid) {
      return;
    }

    this.loginCredentials = this.formLogin.value;
    console.log(this.loginCredentials);

    this.app.login(this.loginCredentials.username, this.loginCredentials.password);
  }

  logout() {
      this.app.logout();
  }


  ngOnInit() {
    this.app.getSessionUser().subscribe(u => this.sessionUser = u);
  }
}