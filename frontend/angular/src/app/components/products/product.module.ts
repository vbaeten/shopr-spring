import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProductListComponent} from "./product-list/product-list.component";
import {ProductDetailsComponent} from "./product-details/product-details.component";
import {MaterialModule} from "../../material.module";
import {RouterModule} from "@angular/router";
import {ProductRoutingModule} from "./product-routing.module";
import {CartContentComponent} from "./cart-content/cart-content.component";
import {ProductFilterPipe} from './product-filter.pipe';
import {CheckoutComponent} from './checkout/checkout.component';

@NgModule({
  declarations: [
    ProductListComponent,
    ProductDetailsComponent,
    CartContentComponent,
    ProductFilterPipe,
    CheckoutComponent
  ],
  imports: [
    CommonModule,
    ProductRoutingModule,
    MaterialModule,
    RouterModule
  ],
  exports: [
    ProductListComponent,
    ProductDetailsComponent,
    CartContentComponent,
    CheckoutComponent
  ],
})
export class ProductModule { }
