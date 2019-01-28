import {Component, OnInit} from '@angular/core';
import {GameService} from "../../../services/game.service";

@Component({
  selector: 'app-games-overview',
  templateUrl: './games-overview.component.html',
  styleUrls: ['./games-overview.component.css']
})
export class GamesOverviewComponent implements OnInit {


  games = []
  displayedColumns: string[] =['no', 'Title', 'Age','details'];


  constructor(private gameService: GameService) {
  }

  ngOnInit() {
    this.gameService.getGames()
      .subscribe(data => {
        this.games = data
      })
  }

}
