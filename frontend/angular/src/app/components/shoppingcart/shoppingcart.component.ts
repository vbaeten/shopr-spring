import {Component, OnInit} from '@angular/core';
import {OrderlineService} from "../../services/orderline.service";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-shoppingcart',
  templateUrl: './shoppingcart.component.html',
  styleUrls: ['./shoppingcart.component.css']
})
export class ShoppingcartComponent implements OnInit {
  totalPrice: number = 0;
  orderlines = [];

  constructor(private orderlineservice: OrderlineService, private userservice: UserService) {
  }

  ngOnInit() {
    this.orderlineservice.getOrderLines().subscribe(data => this.orderlines = data);
  }

  calculateTotal(): number {
    for (let j = 0; j < this.orderlines.length; j++) {
      this.totalPrice = this.totalPrice + this.orderlines[j].subTotal;
    }
    return this.totalPrice;
  }

}
