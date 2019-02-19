import {Component, OnInit} from '@angular/core';
import {User} from "./models/user";
import {Order} from "./models/order";
import {OrderService} from "./services/order.service";
import {log} from "util";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'ShopR';


  constructor(private orderService: OrderService) {

  }

  ngOnInit(): void {
    if (localStorage.getItem('currentUser') === null) {
      localStorage.setItem('currentUser', JSON.stringify(new User()));
    }
    if (localStorage.getItem('currentOrder') === null) {
      this.orderService.createOrder(new Order()).subscribe(newOrder =>{
        localStorage.setItem('currentOrder', JSON.stringify(newOrder));
      });

    }
  }

}
