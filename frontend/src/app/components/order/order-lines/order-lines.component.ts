import {Component, OnInit} from '@angular/core';
import {LoginService} from '../../../services/login.service';
import {ShoppingCartService} from '../../../services/shopping-cart.service';
import {OrderLine} from '../../../models/order-line';
import {User} from '../../../models/user';
import {Order} from '../../../models/order';

@Component({
  selector: 'app-order-lines',
  templateUrl: './order-lines.component.html',
  styleUrls: ['./order-lines.component.css']
})
export class OrderLinesComponent implements OnInit {
  private total = 0;
  currentUser: User = new User();
  order: Order;
  orderLines: OrderLine[];

  displayedColumns: string[] = ['number', 'title', 'quantity', 'price', 'subtotal', 'delete'];
  dataSource;

  constructor(private loginService: LoginService,
              private cartService: ShoppingCartService) {
  }

  ngOnInit() {
    this.getCurrentUser();
  }

  getCurrentUser() {
    this.loginService.getCurrentUser().then(user => {
      this.currentUser = user;
      this.getOrderLines();
    });
  }

  getOrderLines() {
    this.cartService.findCurrentCartByOrderLinesByUserId(this.currentUser.id).subscribe(
      data => {
        this.orderLines = data;
        this.dataSource = this.orderLines;
      }
    );
  }

  sendToOrder() {
    this.order = new Order();
    this.order.user = this.currentUser;
    this.order.orderLines = this.orderLines;
    this.order.orderDate = new Date();
    this.order.total = this.getTotal();
    this.cartService.sendToOrder(this.order).subscribe(() => this.getOrderLines());
  }

  deleteOrderLineById(id: number) {
    this.cartService.deleteOrderLineById(id).subscribe(data => this.getOrderLines());
  }

  deleteOrderLine(id: number) {
    this.cartService.deleteOrderLine(id);
  }

  getTotal() {
    return this.orderLines.map(total => total.subTotal).reduce((acc, value) => acc + value, 0);
  }
}
