import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SharedModule} from "../../modules/shared-module/shared.module";
import {ShoppingCartComponent} from "./shopping-cart.component";
import {OrderService} from "../../services/order.service";
import {OrderLineService} from "../../services/order-line.service";

@NgModule({
  declarations: [ShoppingCartComponent],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [
    ShoppingCartComponent
  ],
  providers: [
    OrderService,
    OrderLineService
  ]
})
export class ShoppingCartModule {
}
