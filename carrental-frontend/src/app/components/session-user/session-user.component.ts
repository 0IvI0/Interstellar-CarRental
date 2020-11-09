import { Component, OnInit } from '@angular/core';
import { AppService } from 'src/app/app.service';
import { Customer } from 'src/app/models/Customer';

@Component({
  selector: 'app-session-user',
  templateUrl: './session-user.component.html',
  styleUrls: ['./session-user.component.css']
})
export class SessionUserComponent implements OnInit {

  sessionUser: Customer | null = null;

  constructor(private app: AppService) {
  }

  ngOnInit() {
    this.app.getSessionUser().subscribe(u => this.sessionUser = u);
  }

  logout() {
    this.app.logout();
  }
}