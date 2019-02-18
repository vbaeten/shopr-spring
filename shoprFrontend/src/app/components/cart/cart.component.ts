import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {Order} from "../../models/Order";
import {Router} from "@angular/router";
import {DataService} from "../../services/data.service";
import {OrderService} from "../../services/order.service";


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  currentUser
  order
  basketList

  constructor(private userService: UserService,
              private router: Router,
              private dataService: DataService,
              private orderService: OrderService,
  ) {
  }

  ngOnInit() {


    this.currentUser = this.userService.getCurrentUser()

    let stored = localStorage.getItem("2")
    this.basketList = JSON.parse(stored)
    console.log(this.currentUser)


  }

  placeOrder() {

    if (this.currentUser.firstName==undefined){
      this.router.navigate(['/'])
      this.dataService.openSnackBar('please log in first', '')
    }else {

      this.order = new Order();
      this.order.user = this.currentUser
      this.order.totalPrice = this.getTotal()
      this.orderService.createOrder(this.order).subscribe(data => this.order = data)
      this.dataService.openSnackBar('your order has been placed', '')
      this.router.navigate(['/thankYou'])
      this.basketList = new Array()
      localStorage.setItem("2", this.basketList)
    }
  }



  getTotal(): number {
    let total = 0
    for (let i = 0; i < this.basketList.length; i++) {
      total = total + this.basketList[i].subTotal
    }
    return total
  }


  isEmpty(): boolean {
    if (this.basketList == null) {
      return true
    }
  }


}
