import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ordering-page',
  templateUrl: './ordering-page.component.html',
  styleUrls: ['./ordering-page.component.css']
})
export class OrderingPageComponent implements OnInit {

  formDatePicker = new FormGroup({
    startDate: new FormControl(''),
    endDate: new FormControl(''),
  });

  private rentalDate = {startDate: '', endDate: ''};

  constructor(private router: Router) { }

  ngOnInit(): void {
  }


  onSubmitDate() {
    this.rentalDate = this.formDatePicker.value;
    console.log(this.rentalDate);
  }

  confirmOrder() {
    // To do
    // Processing the order, mark the car as unavailable / rented, creating the invoice..
    // Sending the user an e-mail with the order number and confirmation text
    // Inform the company about the rent
    this.router.navigate(['order-confirmation']);
  }
}