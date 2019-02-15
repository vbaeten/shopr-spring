import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {User} from "../../domain/user";
import {ArticleService} from "../../services/article.service";
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";
import {Order} from "../../domain/order";
import {OrderService} from "../../services/order.service";

@Component({
  selector: 'app-orderoverview',
  templateUrl: './orderoverview.component.html',
  styleUrls: ['./orderoverview.component.css']
})
export class OrderoverviewComponent implements OnInit {
  displayedColumns: string[] = ['orderId', 'totalPrice', 'orderStatus'];
  dataSource: MatTableDataSource<Order>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  currentUser: User;

  constructor(private articleService: ArticleService, public router: Router, private userService: UserService, private orderService: OrderService) {
  }

  ngOnInit() {
    this.userService.getCurrentUser().then(user => this.currentUser = user);
    this.orderService.allOrders().subscribe(data => {
      this.dataSource = new MatTableDataSource<Order>(data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

}
