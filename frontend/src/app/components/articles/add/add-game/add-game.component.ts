import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Game} from '../../../../models/game';
import {GameService} from '../../../../services/game.service';

@Component({
  selector: 'app-add-game',
  templateUrl: './add-game.component.html',
  styleUrls: ['./add-game.component.css']
})
export class AddGameComponent implements OnInit {

  game: Game;
  addGameForm: FormGroup;

  constructor(private gameService: GameService) {  }

  ngOnInit() {
    this.addGameForm = new FormGroup({
      title: new FormControl(''),
      genre: new FormControl(''),
      minAge: new FormControl(''),
      price: new FormControl(''),
      supplier: new FormControl(''),
      publisher: new FormControl('')
    });
  }

  onSubmit() {
    this.game = new Game();
    this.game.title = this.addGameForm.value.title;
    this.game.genre = this.addGameForm.value.genre;
    this.game.minAge = this.addGameForm.value.minAge;
    this.game.price = this.addGameForm.value.price;
    this.game.supplier = this.addGameForm.value.supplier;
    this.game.publisher = this.addGameForm.value.publisher;
    this.game.type = 'Game';
    this.gameService.addGame(this.game).subscribe(data => this.game = data);
  }
}
