import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RegisterComponent} from "./register/register.component";
import {LoginComponent} from "./login/login.component";
import {UserComponent} from "./user/user.component";
import {UserDetailsComponent} from "./user-details/user-details.component";
import {SharedModule} from "../../modules/shared-module/shared.module";
import {OrderService} from "../../services/order.service";

@NgModule({
  declarations: [
    RegisterComponent,
    LoginComponent,
    UserComponent,
    UserDetailsComponent,
  ],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    RegisterComponent,
    LoginComponent,
    UserComponent,
    UserDetailsComponent,
  ],
  providers: [
    OrderService,
  ]
})
export class UserModule {
}
