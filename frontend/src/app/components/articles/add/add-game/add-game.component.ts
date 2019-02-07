import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {Game} from '../../../../models/game';

@Component({
  selector: 'app-add-game',
  templateUrl: './add-game.component.html',
  styleUrls: ['./add-game.component.css']
})
export class AddGameComponent implements OnInit {

  game: Game;

  constructor() { }

  ngOnInit() {
  }

  onSubmit(form: NgForm) {
    this.game = new Game();
    this.game.title = form.value.title;
    this.game.genre = form.value.genre;
    this.game.minAge = form.value.minAge;
    this.game.price = form.value.price;
    this.game.supplier = form.value.supplier;
    this.game.publisher = form.value.publisher;
  }
}
