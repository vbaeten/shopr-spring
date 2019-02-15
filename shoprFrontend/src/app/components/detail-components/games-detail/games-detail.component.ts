import {Component, Input, OnInit, Output} from '@angular/core';
import {GamesOverviewComponent} from "../../overview/games-overview/games-overview.component";
import {DataService} from "../../../services/data.service";
import {GameService} from "../../../services/game.service";
import {Orderline} from "../../../models/Orderline";
import {NgForm} from "@angular/forms";
import {OrderLineService} from "../../../services/order-line.service";
import {Router} from "@angular/router";
import {Game} from "../../../models/game";

@Component({
  selector: 'app-games-detail',
  templateUrl: './games-detail.component.html',
  styleUrls: ['./games-detail.component.css']
})
export class GamesDetailComponent implements OnInit {


  passedId:number
  game
  order

  orderLine
  quantity:number=0

  constructor(private dataService:DataService,private gameService:GameService,private orderLineService:OrderLineService,private router:Router) { }


  ngOnInit() {
    this.dataService.detailId.subscribe(id=>this.passedId=id)
    this.gameService.getGameById(this.passedId).subscribe(game=>this.game=game)

  }

  delete(){
    this.gameService.deleteById(this.passedId).subscribe(game=>this.game=game)
  }


  addToCart(form:NgForm){

    this.orderLine=new Orderline()
    this.orderLine.item=this.game
    this.orderLine.quantity=form.value.quantity
    this.orderLine.subTotal = this.orderLine.quantity*this.game.price
    this.orderLineService.createOrderLine(this.orderLine).subscribe(data=>this.orderLine=data)
    this.router.navigate(['/itemsOverview'])

  }
  showSnackBar(){
    let message= 'game added to caRt!'
    let action= ''
    this.dataService.openSnackBar(message,action)
  }


}
