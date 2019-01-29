import {AfterViewInit, Component, Input, OnInit} from '@angular/core';
import {GameService} from "../../../services/game.service";
import {DataService} from "../../../services/data.service";

@Component({
  selector: 'app-games-overview',
  templateUrl: './games-overview.component.html',
  styleUrls: ['./games-overview.component.css']
})
export class GamesOverviewComponent implements OnInit{


  games = []
  displayedColumns: string[] =['no', 'Title', 'Age','details'];
  game

  constructor(private gameService: GameService, private dataService:DataService) {
  }

  ngOnInit() {
    this.gameService.getGames()
      .subscribe(data => {
        this.games = data
      })

  }



  passId(toPassId){
    this.dataService.changeId(toPassId)
  }


}
