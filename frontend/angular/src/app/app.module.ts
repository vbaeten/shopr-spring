import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {MaterialModule} from './material.module';
import {ProductListComponent} from './components/products/product-list/product-list.component';
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {LayoutModule} from '@angular/cdk/layout';
import {RegisterComponent} from './components/auth/register/register.component';
import {LoginComponent} from './components/auth/login/login.component';
import {AuthService} from "./services/auth.service";
import {TokenStorage} from "./services/token.storage";
import {AuthInterceptor} from "./services/auth.interceptor";
import {NavbarComponent} from './components/navbar/navbar.component';
import {UserService} from "./services/user.service";
import {ProductDetailsComponent} from './components/products/product-details/product-details.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    DashboardComponent,
    RegisterComponent,
    LoginComponent,
    NavbarComponent,
    ProductDetailsComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MaterialModule,
    HttpClientModule,
    LayoutModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [AuthService, UserService, TokenStorage, { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
