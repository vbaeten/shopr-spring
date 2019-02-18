import { Component, OnInit } from '@angular/core';
import {User} from "../../models/user";
import {UserService} from "../../services/user.service";
import {Order} from "../../models/Order";
import {Router} from "@angular/router";
import {DataService} from "../../services/data.service";
import {OrderService} from "../../services/order.service";
import {OrderLineService} from "../../services/order-line.service";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  currentUser:User
  basketList=new Array()
  order

  constructor(private userService:UserService,
              private router:Router,
              private dataService:DataService,
              private orderService:OrderService,
  ) { }

  ngOnInit() {
   this.currentUser= this.userService.getCurrentUser()
    this.basketList=this.currentUser.orderLines
    console.log(this.currentUser)
    console.log(this.currentUser.orderLines)
    console.log(this.basketList)

  }

  placeOrder() {
    if(this.currentUser === null){
      this.router.navigate(['/'])
      this.dataService.openSnackBar('please log in first','')
    }else {
      this.order = new Order();
      this.order.user = this.currentUser
      this.order.totalPrice = this.getTotal()
      this.orderService.createOrder(this.order).subscribe(data => this.order = data)
      this.currentUser.orderLines=new Array()
      localStorage.setItem("1",JSON.stringify(this.currentUser))
      this.dataService.openSnackBar('your order has been placed','')
      this.router.navigate(['/thankYou'])
    }
  }

  getTotal(): number {
    let total=0
    for (let i = 0; i < this.basketList.length; i++) {
      total = total + this.basketList[i].subTotal
    }
    return total
  }


isEmpty():boolean{

    if (this.basketList.length =0)

    return true
}

}
