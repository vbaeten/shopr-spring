import { Component, OnInit } from '@angular/core';
import {DataService} from "../../../services/data.service";
import {OrderService} from "../../../services/order.service";

@Component({
  selector: 'app-thank-you',
  templateUrl: './thank-you.component.html',
  styleUrls: ['./thank-you.component.css']
})
export class ThankYouComponent implements OnInit {

  passedId
  placedOrder

  constructor(private dataService:DataService, private orderService:OrderService) { }

  ngOnInit() {

  }

}
