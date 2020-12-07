import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { SearchFilterPipe } from './pipes/search-filter.pipe';
import { BooleanDetailsPipe } from './pipes/booleanDetails.pipe';
import { AppComponent } from './app.component';
import { AppService } from './app.service';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { CarListComponent } from './components/car-list/car-list.component';
import { RegisterComponent } from './components/register/register.component';
import { SessionUserComponent } from './components/session-user/session-user.component';
import { LogoComponent } from './components/logo/logo.component';
import { CarDetailsComponent } from './components/car-details/car-details.component';
import { RentConfirmationComponent } from './components/rent-confirmation/rent-confirmation.component';
import { OrderingPageComponent } from './components/ordering-page/ordering-page.component';


@NgModule({
  declarations: [
    AppComponent,
    SearchFilterPipe,
    BooleanDetailsPipe,
    HomeComponent,
    LoginComponent,
    CarListComponent,
    RegisterComponent,
    SessionUserComponent,
    LogoComponent,
    CarDetailsComponent,
    RentConfirmationComponent,
    OrderingPageComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
  ],
  providers: [AppService],
  bootstrap: [AppComponent]
})
export class AppModule { }