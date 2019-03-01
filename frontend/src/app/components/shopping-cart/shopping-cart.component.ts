import {Component, OnInit, ViewChild} from '@angular/core';
import {Article} from "../../models/article";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {Router} from "@angular/router";
import {OrderLine} from "../../models/orderLine";
import {OrderLineService} from "../../services/order-line.service";
import {Order} from "../../models/order";
import {OrderService} from "../../services/order.service";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {
  selectedArticle: Article;
  displayedColumns: string[] = ['title', 'price', 'quantity', 'subtotal', 'delete'];
  orderLines = new MatTableDataSource<OrderLine>();
  newOrder: Order;
  shoppingCart: OrderLine[];

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private orderService: OrderService, private orderLineService: OrderLineService, private userService: UserService, private router: Router) {
  }

  ngOnInit() {
    this.getCart();
  }

  ngAfterViewInit(): void {
    this.setSortAndPaginator();
  }

  deleteOrderLine(index: number) {
    const data = this.orderLines.data;
    data.splice((this.paginator.pageIndex * this.paginator.pageSize) + index, 1);
    this.orderLines.data = data;
    this.shoppingCart = data;
    if (this.shoppingCart.length < 1) {
      this.orderLineService.deleteCartFromStorage();
    } else {
      this.orderLineService.setCartToStorage(this.shoppingCart);
    }
  };

  clearCart() {
    this.shoppingCart = [];
    this.orderLines.data = [];
    this.orderLineService.deleteCartFromStorage();
  }

  getCart() {
    this.shoppingCart = this.orderLineService.getCartFromStorage();
    this.orderLines = new MatTableDataSource<OrderLine>(this.shoppingCart);
    this.setSortAndPaginator();

  }

  getTotalPrice() {
    let totalPrice = this.shoppingCart.map(o => o.subtotal * o.quantity).reduce((acc, value) => acc + value, 0);
    return parseFloat(totalPrice.toFixed(2));
  }

  buy(cart: OrderLine[]) {
    if (this.userService.getCurrentUser() === null) {
      this.router.navigate(["/login/"]);
    } else {
      this.newOrder = new Order();
      this.newOrder.orderLines = cart;
      this.newOrder.user = this.userService.getCurrentUser();
      this.orderService.createOrder(this.newOrder);
      this.getCart();
    }
  }

  calculateSubtotal(quantity: number, price: number): number {
    let subtotal = quantity * price;
    return parseFloat(subtotal.toFixed(2));
  }

  private setSortAndPaginator() {
    this.orderLines.sort = this.sort;
    this.orderLines.paginator = this.paginator;
  }

}
