import { Component, OnInit } from '@angular/core';
import { AppService } from 'src/app/app.service';
import { Customer } from 'src/app/models/Customer';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-session-user',
  templateUrl: './session-user.component.html',
  styleUrls: ['./session-user.component.css']
})
export class SessionUserComponent implements OnInit {

  sessionUser: User | null = null;

  constructor(private app: AppService) {
  }

  ngOnInit() {
    this.app.getSessionUser().subscribe(u => this.sessionUser = u);
  }

  logout() {
    this.app.logout();
  }
}