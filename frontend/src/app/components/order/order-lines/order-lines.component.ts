import {Component, Input, OnInit} from '@angular/core';
import {LoginService} from '../../../services/login.service';
import {ShoppingCartService} from '../../../services/shopping-cart.service';
import {OrderLine} from '../../../models/order-line';
import {User} from "../../../models/user";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-order-lines',
  templateUrl: './order-lines.component.html',
  styleUrls: ['./order-lines.component.css']
})
export class OrderLinesComponent implements OnInit {

  currentUser: User;
  orderLines: OrderLine[];

  displayedColumns: string[] = ['title', 'quantity', 'price'];
  dataSource;

  constructor(private loginService: LoginService,
              private cartService: ShoppingCartService) { }

  ngOnInit() {
    this.getCurrentUser();
  }

  getCurrentUser() {
    this.loginService.getCurrentUser().then(user => this.currentUser = user);
    this.getOrderLines();
  }

  getOrderLines() {
    this.cartService.findByOrderLinesByUserId(this.currentUser.id).subscribe(
      data => {
        this.orderLines = data;
        this.dataSource = this.orderLines;
      }
    );
  }
}
