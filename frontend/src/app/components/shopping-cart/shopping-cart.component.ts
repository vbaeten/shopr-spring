import {Component, OnInit, ViewChild} from '@angular/core';
import {Article} from "../../models/article";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {ActivatedRoute, Router} from "@angular/router";
import {OrderLine} from "../../models/orderLine";
import {OrderLineService} from "../../services/order-line.service";
import {Order} from "../../models/order";
import {OrderService} from "../../services/order.service";

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {
  selectedArticle: Article;
  displayedColumns: string[] = ['title', 'price', 'quantity', 'subtotal', 'delete'];
  dataSource = new MatTableDataSource<OrderLine>();
  currentOrder: Order;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private orderService: OrderService, private orderLineService: OrderLineService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.getCurrentOrder();
  }

  ngAfterViewInit(): void {
    this.setSortAndPaginator();
  }


  private setSortAndPaginator() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  deleteOrderLine = (id: number) => {
    this.orderLineService.deleteOrderLine(id).subscribe()
    };


  getCurrentOrder() {
    let currentOrderFromStorage = this.orderService.getCurrentOrderFromStorage();
    this.orderLineService.getOrderLinesByOrderId(currentOrderFromStorage.orderId).subscribe(orderLines => {
      this.dataSource = new MatTableDataSource<OrderLine>(orderLines);
      this.setSortAndPaginator();
    })
  }

  buy(order: Order) {
    order.confirmed = true;
    this.orderService.edit(order);
    let newOrder = new Order();
    localStorage.setItem('currentOrder', JSON.stringify(new Order()))
  }

  calculateSubtotal(quantity: number, price: number): number {
    let subtotal = quantity * price;
    return parseFloat(subtotal.toFixed(2));
  }
}
