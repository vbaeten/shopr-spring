import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {DashboardComponent} from "../dashboard/dashboard.component";
import {RegisterComponent} from "./register/register.component";
import {LoginComponent} from "./login/login.component";
import {SidenavComponent} from "../dashboard/sidenav/sidenav.component";
import {MaterialModule} from "../../material.module";
import {RouterModule} from "@angular/router";
import {MatSidenavModule} from "@angular/material";
import {AuthRoutingModule} from "./auth-routing.module";

@NgModule({
  declarations: [
    DashboardComponent,
    RegisterComponent,
    LoginComponent,
    SidenavComponent
  ],
  imports: [
    CommonModule,
    AuthRoutingModule,
    MaterialModule,
    RouterModule,
    MatSidenavModule
  ],
  exports: [
    DashboardComponent,
    RegisterComponent,
    LoginComponent,
    SidenavComponent
  ]
})
export class AuthModule { }
