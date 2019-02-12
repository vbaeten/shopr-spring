import {Component, OnInit} from '@angular/core';
import {OrderLineService} from "../../services/order-line.service";
import {Order} from "../../models/Order";
import {OrderService} from "../../services/order.service";
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {DataService} from "../../services/data.service";

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  orderLines = []
  order
  total: number = 0
  currentUser
  orderLine


  constructor(private orderLineService: OrderLineService,
              private orderService: OrderService,
              private userService: UserService,
              private router:Router,
              private dataService:DataService
              ) {
  }

  ngOnInit() {
    this.orderLineService.getOrderLines().subscribe(data => this.orderLines = data)
    this.currentUser = this.userService.getCurrentUser()
  }


  placeOrder() {
    if(this.currentUser === null){
      this.router.navigate(['/'])
      this.dataService.openSnackBar('please log in first','')
    }else {
      this.order = new Order();
      this.order.orderLines = this.orderLines;
      this.order.user = this.currentUser
      this.order.totalPrice = this.getTotal()
      this.orderService.createOrder(this.order).subscribe(data => this.order = data)
      this.dataService.openSnackBar('your order has been placed','')
      this.router.navigate(['/thankYou'])
    }
  }

  getTotal(): number {
    let i
    for (i = 0; i < this.orderLines.length; i++) {
      this.total = this.total + this.orderLines[i].subTotal
    }
    return this.total
  }

  deleteById(id:number){
    console.log(id)
    this.orderLineService.deleteById(id).subscribe(data=>this.orderLine=data)
  }


}
