import {Component, OnInit} from '@angular/core';
import {OrderService} from "../../../services/order.service";
import {ShoppingCartService} from "../../../services/shopping-cart.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  constructor(private orderService: OrderService, private shoppingCartService: ShoppingCartService, private router: Router) { }

  ngOnInit() {
  }

  processOrder() {
    this.orderService.processOrder();
    setTimeout(() => {
      this.shoppingCartService.empty();
      alert("Thank you, your items will be shipped ASAP");
      this.router.navigate(['']);
    }, 500);
  }

}
