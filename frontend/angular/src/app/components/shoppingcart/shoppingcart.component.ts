import {Component, OnInit} from '@angular/core';
import {OrderlineService} from "../../services/orderline.service";
import {UserService} from "../../services/user.service";
import {MatTableDataSource} from "@angular/material";
import {Orderline} from "../../domain/orderline";
import {ArticleService} from "../../services/article.service";
import {User} from "../../domain/user";

@Component({
  selector: 'app-shoppingcart',
  templateUrl: './shoppingcart.component.html',
  styleUrls: ['./shoppingcart.component.css']
})
export class ShoppingcartComponent implements OnInit {
  displayedColumns: string[] = ['title', 'type', 'price', 'quantity', 'subTotal'];
  dataSource: MatTableDataSource<Orderline>;
  totalPrice: number = 0;
  orderlines = [];
  currentUser: User;

  constructor(private orderlineservice: OrderlineService, private userService: UserService, private articleservice: ArticleService) {
  }

  ngOnInit() {
    this.userService.getCurrentUser().then(user => this.currentUser = user);
    this.orderlineservice.getOrderLines().subscribe(data => {
      this.dataSource = new MatTableDataSource<Orderline>(data);
      this.orderlines = this.dataSource.data;
      this.calculateTotal()
    });
  }

  calculateTotal(): number {
    for (let j = 0; j < this.orderlines.length; j++) {
      this.totalPrice = this.totalPrice + this.orderlines[j].subTotal;
      this.totalPrice.toFixed(2);
    }
    return this.totalPrice

  }


}
