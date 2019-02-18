import { Component, OnInit } from '@angular/core';
import {DataService} from "../../../services/data.service";
import {LpService} from "../../../services/lp.service";
import {NgForm} from "@angular/forms";
import {Orderline} from "../../../models/Orderline";
import {OrderLineService} from "../../../services/order-line.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-lps-detail',
  templateUrl: './lps-detail.component.html',
  styleUrls: ['./lps-detail.component.css']
})
export class LpsDetailComponent implements OnInit {

  passedId:number
  lp
  orderLine
  basketList

  constructor(private dataService:DataService,private lpService:LpService,private orderLineService:OrderLineService,private router:Router) { }


  ngOnInit() {
    this.dataService.detailId.subscribe(id=>this.passedId=id)
    this.lp= this.lpService.getById(this.passedId).subscribe(lp=>this.lp=lp)
    if (this.basketList == undefined) {
      this.basketList = new Array()
    }
  }

  delete(){
    console.log(this.passedId)
    this.lpService.deleteById(this.passedId).subscribe(lp=>this.lp=lp)
  }


  addToCart(form: NgForm) {

    this.orderLine = new Orderline()
    this.orderLine.item = this.lp
    this.orderLine.quantity = form.value.quantity
    this.orderLine.subTotal = this.orderLine.quantity * this.lp.price
    this.basketList.push(this.orderLine)

    this.orderLineService.createOrderLine(this.orderLine).subscribe((data) => {
      this.orderLine = data
    })

    console.log(this.basketList)
    localStorage.setItem("2",JSON.stringify(this.basketList))
  }

  showSnackBar(){
    let message= 'Lp added to caRt!'
    let action= ''
    this.dataService.openSnackBar(message,action)
  }

}
