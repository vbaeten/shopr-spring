import {Component, OnInit} from '@angular/core';
import {GameService} from "../../services/game.service";
import {Game} from "../../domain/Game";

export interface Gamegenre {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-creategame',
  templateUrl: './creategame.component.html',
  styleUrls: ['./creategame.component.css']
})
export class CreategameComponent implements OnInit {
  price: number;
  title: string;
  publisher: string;
  supplierId: string;
  minimumAge: number;
  gameGenre: string;
  gamegenres: string[];

  constructor(private service: GameService) {

  }
  ngOnInit() {
    this.service.getGameGenres().subscribe(gamegenres => this.gamegenres = gamegenres);
  }

  submit() {
    let newGame = new Game(this.title, 'game', this.price, this.supplierId, this.gameGenre, this.minimumAge, this.publisher);
    this.service.createGame(newGame).toPromise();
  }
}
