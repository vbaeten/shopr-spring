import {Component, OnInit} from '@angular/core';
import {OrderlineService} from "../../services/orderline.service";
import {UserService} from "../../services/user.service";
import {MatTableDataSource} from "@angular/material";
import {Orderline} from "../../domain/orderline";
import {ArticleService} from "../../services/article.service";
import {User} from "../../domain/user";
import {OrderService} from "../../services/order.service";
import {Order} from "../../domain/order";
import {Router} from "@angular/router";

@Component({
  selector: 'app-shoppingcart',
  templateUrl: './shoppingcart.component.html',
  styleUrls: ['./shoppingcart.component.css']
})
export class ShoppingcartComponent implements OnInit {
  displayedColumns: string[] = ['title', 'type', 'price', 'quantity', 'subTotal', 'delete'];
  dataSource: MatTableDataSource<Orderline>;
  totalPrice: number = 0;
  orderlines = [];
  currentUser: User;
  order: Order;

  constructor(private router: Router, private orderlineservice: OrderlineService, private userService: UserService, private articleservice: ArticleService, private orderService: OrderService) {
  }

  ngOnInit() {
    this.userService.getCurrentUser().then(user => {
      this.currentUser = user;
      this.fetchOrderlines();
    });
  }

  delete(orderline: Orderline) {
    this.orderlineservice.deleteOrderlineById(orderline.orderlineId).subscribe(() => {
      this.orderlines = this.orderlines.filter(ol => ol !== orderline);
      this.dataSource = new MatTableDataSource<Orderline>(this.orderlines);
      this.calculateTotal();
      console.log(this.orderlines);
    });
  }

  calculateTotal(): number {
    this.totalPrice = 0;
    for (let j = 0; j < this.orderlines.length; j++) {
      this.totalPrice = this.totalPrice + this.orderlines[j].subTotal;
      this.totalPrice.toFixed(2);
    }
    return this.totalPrice;
  }

  orderThisOrder(order: Order) {
    this.orderService.orderNow(order).subscribe();
    this.router.navigate(["/orders/", this.currentUser.userId]);
  }

  private fetchOrderlines() {
    this.orderService.findCurrentCartByUserId(this.currentUser.userId).subscribe(order => {
      if (order) {
        this.order = order;
        this.dataSource = new MatTableDataSource<Orderline>(order.orderlineList);
        this.orderlines = this.dataSource.data;
        this.calculateTotal();
      }
    });
  }


}
