import { Component, OnInit } from '@angular/core';
import {GamesOverviewComponent} from "../../overview/games-overview/games-overview.component";
import {DataService} from "../../../services/data.service";
import {GameService} from "../../../services/game.service";
import {Orderline} from "../../../models/Orderline";
import {NgForm} from "@angular/forms";
import {OrderLineService} from "../../../services/order-line.service";

@Component({
  selector: 'app-games-detail',
  templateUrl: './games-detail.component.html',
  styleUrls: ['./games-detail.component.css']
})
export class GamesDetailComponent implements OnInit {


  passedId:number
  game

  orderline:Orderline

  constructor(private dataService:DataService,private gameService:GameService,private orderLineService:OrderLineService) { }


  ngOnInit() {
    this.dataService.detailId.subscribe(id=>this.passedId=id)
    this.game= this.gameService.getGameById(this.passedId).subscribe(game=>this.game=game)
  }

  delete(){
    console.log(this.passedId)
    this.gameService.deleteById(this.passedId).subscribe(game=>this.game=game)
  }


  addToCart(form:NgForm){

    this.orderline=new Orderline()
    this.orderline.item=this.game
    this.orderline.quantity=form.value.quantity
    this.orderline.subTotal = this.orderline.quantity*this.game.price
    console.log(this.orderline.quantity)
    console.log(this.orderline.subTotal)
    this.orderLineService.createOrderLine(this.orderline).subscribe(data=>this.orderline=data)
  }


}
