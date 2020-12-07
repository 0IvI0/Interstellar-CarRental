import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-rent-confirmation',
  templateUrl: './rent-confirmation.component.html',
  styleUrls: ['./rent-confirmation.component.css']
})
export class RentConfirmationComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  goToCarList(): void {
    this.router.navigate(['carlist']);
  }

  goToRentHistory() {
    // To do..
  }

  goToConfirmErrorPage() {
    // To do..
  }
}