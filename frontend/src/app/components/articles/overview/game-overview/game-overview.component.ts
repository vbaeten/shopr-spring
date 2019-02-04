import { Component, OnInit } from '@angular/core';
import {Game} from '../../../../models/game';
import {GameService} from "../../../../services/game.service";

@Component({
  selector: 'app-game-overview',
  templateUrl: './game-overview.component.html',
  styleUrls: ['./game-overview.component.css']
})
export class GameOverviewComponent implements OnInit {

  games: Game[] = [];
  dataSource;
  displayedColumns: string[] = ['id', 'title', 'price'];


  constructor(private gameService: GameService) { }

  ngOnInit() {
    this.gameService.getGames().subscribe(
      data => {
        this.games = data;
        this.dataSource = this.games;
      }
    )
  }

}
