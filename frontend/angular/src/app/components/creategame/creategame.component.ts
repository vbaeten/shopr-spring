import {Component, OnInit} from '@angular/core';
import {GameService} from "../../services/game.service";
import {Game} from "../../domain/Game";
import {Router} from "@angular/router";


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
  gameGenres: string[];

  constructor(private service: GameService, public router: Router) {

  }
  ngOnInit() {
    this.service.getGameGenres().subscribe(gameGenres => this.gameGenres = gameGenres);
  }

  submit() {
    let newGame = new Game(this.title, 'game', this.price, this.supplierId, this.gameGenre, this.minimumAge, this.publisher);
    this.service.createGame(newGame).toPromise();
    this.router.navigate(['/articles'])
  }
}
