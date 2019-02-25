import {Component, OnInit} from '@angular/core';
import {User} from "./models/user";
import {Order} from "./models/order";
import {OrderService} from "./services/order.service";


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
    this.orderService.setCurrentOrderToStorage(new Order())

    }


}
