import { Component, OnInit } from '@angular/core';
import {GamesOverviewComponent} from "../../overview/games-overview/games-overview.component";
import {DataService} from "../../../services/data.service";
import {GameService} from "../../../services/game.service";

@Component({
  selector: 'app-games-detail',
  templateUrl: './games-detail.component.html',
  styleUrls: ['./games-detail.component.css']
})
export class GamesDetailComponent implements OnInit {


  passedId:number
  game

  constructor(private dataService:DataService,private gameService:GameService) { }


  ngOnInit() {
    this.dataService.detailId.subscribe(id=>this.passedId=id)
    this.game= this.gameService.getGameById(this.passedId).subscribe(game=>this.game=game)
  }

  delete(){
    console.log(this.passedId)
    this.gameService.deleteById(this.passedId).subscribe(game=>this.game=game)
  }




}
