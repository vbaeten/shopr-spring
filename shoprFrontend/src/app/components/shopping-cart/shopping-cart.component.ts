import { Component, OnInit } from '@angular/core';
import {OrderLineService} from "../../services/order-line.service";

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  orderLines = []

  constructor( private orderLineService:OrderLineService) { }

  ngOnInit() {
    this.orderLineService.getOrderLines().subscribe(data=>this.orderLines=data)
  }


}
