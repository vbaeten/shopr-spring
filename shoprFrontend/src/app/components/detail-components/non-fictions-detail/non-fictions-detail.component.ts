import { Component, OnInit } from '@angular/core';
import {DataService} from "../../../services/data.service";
import {NonFictionService} from "../../../services/non-fiction.service";
import {NgForm} from "@angular/forms";
import {Orderline} from "../../../models/Orderline";
import {OrderLineService} from "../../../services/order-line.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-non-fictions-detail',
  templateUrl: './non-fictions-detail.component.html',
  styleUrls: ['./non-fictions-detail.component.css']
})
export class NonFictionsDetailComponent implements OnInit {

  passedId:number
  nonFiction
  orderLine

  constructor(private dataService:DataService,private nonFictionService:NonFictionService, private orderLineService:OrderLineService, private router:Router) { }


  ngOnInit() {
    this.dataService.detailId.subscribe(id=>this.passedId=id)
    this.nonFiction= this.nonFictionService.getById(this.passedId).subscribe(nonFiction=>this.nonFiction=nonFiction)
  }

  delete(){
    console.log(this.passedId)
    this.nonFictionService.deleteById(this.passedId).subscribe(nonFiction=>this.nonFiction=nonFiction)
  }

  addToCart(form:NgForm){

    this.orderLine=new Orderline()
    this.orderLine.item=this.nonFiction
    this.orderLine.quantity=form.value.quantity
    this.orderLine.subTotal = this.nonFiction.quantity*this.nonFiction.price
    this.orderLineService.createOrderLine(this.orderLine).subscribe(data=>this.orderLine=data)
    this.router.navigate(['/itemsOverview'])

  }

  showSnackBar(){
    let message= 'book added to caRt!'
    let action= ''
    this.dataService.openSnackBar(message,action)
  }

}
