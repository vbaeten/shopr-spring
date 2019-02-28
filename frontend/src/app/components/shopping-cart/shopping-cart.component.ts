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

  deleteOrderLine = (id: number) => {
    this.orderLineService.deleteOrderLine(id).subscribe()
  };

  getCart() {
    let cartFromStorage = this.orderLineService.getCartFromStorage();
    this.orderLines = new MatTableDataSource<OrderLine>(cartFromStorage);
    this.setSortAndPaginator();

  }

  buy(cart: OrderLine[]) {
    if (this.userService.getCurrentUser() === null) {
      this.router.navigate(["/login/"]);
    } else {
      this.newOrder = new Order();
      this.newOrder.orderLines = cart;
      this.newOrder.user = this.userService.getCurrentUser();
      this.orderService.createOrder(this.newOrder);
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
