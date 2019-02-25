import {Component, Input, OnInit} from '@angular/core';
import {Game} from "../../../../../models/game";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {GameService} from "../../../../../services/game.service";
import {GameGenre} from "../../../../../models/game-genre";

@Component({
  selector: 'app-create-game',
  templateUrl: './create-game.component.html',
  styleUrls: ['./create-game.component.css']
})
export class CreateGameComponent implements OnInit {

  @Input() type: string;
  game: Game;
  createGameForm: FormGroup = this.formBuilder.group(
    {
      type: ['', Validators.required],
      title: ['', Validators.required],
      price: ['', Validators.required],
      supplierId: ['', Validators.required],
      publisher: ['', Validators.required],
      minimumAge: ['', Validators.required],
      gameGenre: ['', Validators.required],
    });

  constructor(private gameService: GameService,
              private formBuilder: FormBuilder) {
  }

  gameGenres(): Array<string> {
    return Object.keys(GameGenre).filter(
      (type) => isNaN(<any>type) && type !== 'values'
    );
  }

  ngOnInit() {
    this.createGameForm.patchValue({type: this.type});
  }

  createGame = () => {
    this.game = new Game();
    this.game.type = this.createGameForm.value.type;
    this.game.title = this.createGameForm.value.title;
    this.game.price = this.createGameForm.value.price;
    this.game.supplierId = this.createGameForm.value.supplierId;
    this.game.publisher = this.createGameForm.value.publisher;
    this.game.minimumAge = this.createGameForm.value.minimumAge;
    this.game.gameGenre = this.createGameForm.value.gameGenre;

    this.gameService.createGame(this.game);

  }
}
