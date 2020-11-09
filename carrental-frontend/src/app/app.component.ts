import { Component, OnInit } from '@angular/core';
import { AppService } from './app.service';
import { Customer } from './models/Customer';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  sessionUser: Customer | null = null;

  constructor(private app: AppService) {
  }
  
  ngOnInit() {
    this.app.getSessionUser().subscribe(u => this.sessionUser = u);
  }
}