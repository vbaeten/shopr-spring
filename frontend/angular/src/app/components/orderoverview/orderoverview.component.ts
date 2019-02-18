import {Component, OnInit, ViewChild} from '@angular/core';
import {Order} from "../../domain/order";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {User} from "../../domain/user";
import {ArticleService} from "../../services/article.service";
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";
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
  totalPriceOfOrder: number = 0;

  constructor(private articleService: ArticleService, public router: Router, private userService: UserService, private orderService: OrderService) {
  }

  ngOnInit() {
    this.userService.getCurrentUser().then(user => {
      this.currentUser = user
      this.getAllOrders();
      // this.getTotalPrice();
    });
  }

  private getAllOrders() {
    this.orderService.allOrders(this.currentUser.userId).subscribe(data => {
      for (let p = 0; p < data.length; p++) {
        let price: number = 0;
        for (let o = 0; o < data[p].orderlineList.length; o++) {
          price += data[p].orderlineList[o].subTotal;
        }
        data[p].price = price;
      }
      this.dataSource = new MatTableDataSource<Order>(data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  // private getTotalPrice(){
  //   this.totalPriceOfOrder = this.shoppingCartComponent.calculateTotal();
  // }

}

