import { Component, OnInit } from '@angular/core';
import {Game} from '../../../../models/game';

@Component({
  selector: 'app-game-overview',
  templateUrl: './game-overview.component.html',
  styleUrls: ['./game-overview.component.css']
})
export class GameOverviewComponent implements OnInit {

  games: Game[] = [];

  constructor() { }

  ngOnInit() {
  }

}
