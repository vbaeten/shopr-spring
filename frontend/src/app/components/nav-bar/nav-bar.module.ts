import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SharedModule} from "../../modules/shared-module/shared.module";
import {NavBarComponent} from "./nav-bar.component";
import {UserService} from "../../services/user.service";

@NgModule({
  declarations: [NavBarComponent],
  imports: [
    CommonModule,
    SharedModule,
  ],
  exports: [
    NavBarComponent
  ],
  providers: [
    UserService
  ]
})
export class NavBarModule {
}
