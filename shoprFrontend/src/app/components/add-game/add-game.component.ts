import {Component, OnInit, ViewChild} from '@angular/core';
import {GameService} from "../../services/game.service";
import {Game} from "../../models/game";
import {NgForm} from "@angular/forms";
import {Item} from "../../models/item";
import {AddItemsComponent} from "../add-items/add-items.component";


@Component({
  selector: 'app-add-game',
  templateUrl: './add-game.component.html',
  styleUrls: ['./add-game.component.css']
})
export class AddGameComponent implements OnInit {

  private _title: string;
  private _price: number;
  game: Game;

  constructor(private gameService: GameService) {
  }


  ngOnInit() {

  }


  addGame(form: NgForm) {

    this.game = new Game()
    this.game.minAge = form.value.minAge
    this.game.price = this._price;
    this.game.title = this._title;
    this.game.genre = form.value.genre
    this.game.publisher = form.value.publisher
    this.gameService.createGame(this.game)
      .subscribe(data => this.game = data)

  }

  setTitle(value: string) {
    this._title = value;
  }

  setPrice(value: number) {
    this._price = value;
  }
}
