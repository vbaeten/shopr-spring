import { Component, OnInit } from '@angular/core';
import {Order} from '../../../../models/order';
import {User} from '../../../../models/user';
import {LoginService} from '../../../../services/login.service';
import {OrderService} from '../../../../services/order.service';
import {OrderLine} from "../../../../models/order-line";

@Component({
  selector: 'app-order-overview',
  templateUrl: './order-overview.component.html',
  styleUrls: ['./order-overview.component.css']
})
export class OrderOverviewComponent implements OnInit {

  currentUser: User;
  orders: Order[];
  orderLine = '';
  orderLines: OrderLine[];

  displayedColumns: string[] = ['orderid', 'orderdate', 'total', 'detail'];
  dataSource;

  constructor(private loginService: LoginService,
              private orderService: OrderService) { }

  ngOnInit() {
   this.getCurrentUser();
  }

  getCurrentUser() {
    this.loginService.getCurrentUser().then(user => {
      this.currentUser = user;
      this.getOrders();
    });
  }

  getOrders() {
    this.orderService.findOrdersByUserId(this.currentUser.id).subscribe(
      data => {
        this.orders = data;
        this.dataSource = this.orders;
      }
    );
  }

}
