import { Component, OnInit } from '@angular/core';
import {DataService} from "../../../services/data.service";
import {LpService} from "../../../services/lp.service";
import {NgForm} from "@angular/forms";
import {Orderline} from "../../../models/Orderline";
import {OrderLineService} from "../../../services/order-line.service";

@Component({
  selector: 'app-lps-detail',
  templateUrl: './lps-detail.component.html',
  styleUrls: ['./lps-detail.component.css']
})
export class LpsDetailComponent implements OnInit {

  passedId:number
  lp
  orderLine

  constructor(private dataService:DataService,private lpService:LpService,private orderLineService:OrderLineService) { }


  ngOnInit() {
    this.dataService.detailId.subscribe(id=>this.passedId=id)
    this.lp= this.lpService.getById(this.passedId).subscribe(lp=>this.lp=lp)
  }

  delete(){
    console.log(this.passedId)
    this.lpService.deleteById(this.passedId).subscribe(lp=>this.lp=lp)
  }

  addToCart(form:NgForm){

    this.orderLine=new Orderline()
    this.orderLine.item=this.lp
    this.orderLine.quantity=form.value.quantity
    this.orderLine.subTotal = this.lp.quantity*this.lp.price

    this.orderLineService.createOrderLine(this.orderLine).subscribe(data=>this.orderLine=data)
  }

}
