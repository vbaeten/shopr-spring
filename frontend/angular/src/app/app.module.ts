import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {MaterialModule} from './material.module';
import {LayoutModule} from '@angular/cdk/layout';
import {AuthService} from "./services/auth.service";
import {TokenStorage} from "./services/token.storage";
import {AuthInterceptor} from "./services/auth.interceptor";
import {NavbarComponent} from './components/navbar/navbar.component';
import {UserService} from "./services/user.service";
import {ProductModule} from "./components/products/product.module";
import {AuthModule} from "./components/auth/auth.module";
import {ShoppingCartService} from "./services/shopping-cart.service";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    LayoutModule,
    ReactiveFormsModule,
    FormsModule,
    MaterialModule,
    ProductModule,
    AuthModule
  ],
  providers: [
    AuthService,
    UserService,
    TokenStorage,
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    { provide: ShoppingCartService, useClass: ShoppingCartService }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
