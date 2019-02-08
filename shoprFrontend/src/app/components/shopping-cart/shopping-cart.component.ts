import {Component, OnInit} from '@angular/core';
import {OrderLineService} from "../../services/order-line.service";
import {Order} from "../../models/Order";
import {OrderService} from "../../services/order.service";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  orderLines = [];
  order;
  total: number = 0


  constructor(private orderLineService: OrderLineService, private orderService: OrderService, private userService: UserService) {
  }

  ngOnInit() {
    this.orderLineService.getOrderLines().subscribe(data => this.orderLines = data)
  }


  placeOrder() {
    this.order = new Order();
    this.order.orderLines = this.orderLines;
    this.order.user = this.userService.getCurrentUser()
    this.order.totalPrice = this.getTotal()
    this.orderService.createOrder(this.order).subscribe(data => this.order = data)
    console.log(this.order.totalPrice)
  }

  getTotal(): number {
    let i
    for (i = 0; i < this.orderLines.length; i++) {
      this.total = this.total + this.orderLines[i].subTotal
    }
    return this.total
  }


}
