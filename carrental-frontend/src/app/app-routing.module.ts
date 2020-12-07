import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CarDetailsComponent } from './components/car-details/car-details.component';
import { CarListComponent } from './components/car-list/car-list.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { OrderingPageComponent } from './components/ordering-page/ordering-page.component';
import { RentConfirmationComponent } from './components/rent-confirmation/rent-confirmation.component';


const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'carlist', component: CarListComponent },
  { path: 'cardetails/:vehicleID', component: CarDetailsComponent },
  { path: 'order-processing', component: OrderingPageComponent },
  { path: 'order-confirmation', component: RentConfirmationComponent },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
