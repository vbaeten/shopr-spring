import {Component, Input, OnInit} from '@angular/core';
import {Game} from "../../../../../models/game";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {GameService} from "../../../../../services/game.service";
import {GameGenre} from "../../../../../models/game-genre";
import {ActivatedRoute} from "@angular/router";
import {ArticleService} from "../../../../../services/article.service";

@Component({
  selector: 'app-create-game',
  templateUrl: './create-game.component.html',
  styleUrls: ['./create-game.component.css']
})
export class CreateGameComponent implements OnInit {

  @Input() type: string;
  game: Game;
  createGameForm: FormGroup;
  articleId: number;
  selectedArticle: Game = new Game();

  constructor(private activatedRoute: ActivatedRoute, private articleService: ArticleService, private gameService: GameService, private formBuilder: FormBuilder) {
  }

  gameGenres(): Array<string> {
    return Object.keys(GameGenre).filter(
      (type) => isNaN(<any>type) && type !== 'values'
    );
  }

  ngOnInit() {
    this.fillInForm();
    this.activatedRoute.params.subscribe(params => {
      this.articleId = +params['id'];
      if (this.articleId) {
        this.articleService.getArticleById(this.articleId).subscribe(data => {
          this.selectedArticle = data as Game;
          this.type = this.selectedArticle.type;
          this.fillInForm();
        })
      }
    });

  }

  createGame = () => {
    this.game = new Game();
    if (this.createGameForm.value.id) {
      this.game.articleId = this.createGameForm.value.id;
    }
    this.game.type = this.createGameForm.value.type.toLowerCase();
    this.game.title = this.createGameForm.value.title;
    this.game.price = this.createGameForm.value.price;
    this.game.supplierId = this.createGameForm.value.supplierId;
    this.game.publisher = this.createGameForm.value.publisher;
    this.game.minimumAge = this.createGameForm.value.minimumAge;
    this.game.gameGenre = this.createGameForm.value.gameGenre;
    if (this.createGameForm.value.id) {
      this.gameService.edit(this.game.articleId, this.game);
    } else {
      this.gameService.createGame(this.game);
    }
  };


  validation_messages = {
    'title': [
      {type: 'required', message: 'Title is required'},
      {type: 'maxlength', message: 'Title cannot be more than 100 characters long'},
    ],
    'price': [
      {type: 'required', message: 'Price is required'},
      {type: 'min', message: 'Price must be at least $0.01'},
      {type: 'max', message: 'Price cannot be more than $9999.99'},
    ],
    'supplierId': [
      {type: 'required', message: 'Supplier id is required'},
      {type: 'maxlength', message: 'Supplier id cannot be more than 100 characters long'},
    ],
    'publisher': [
      {type: 'maxlength', message: 'Publisher cannot be more than 100 characters long'},
    ],
    'minimumAge': [
      {type: 'pattern', message: 'Minimum age must contain only numbers'},
      {type: 'min', message: 'Minimum age must be at least 1'},
      {type: 'max', message: 'Minimum age may not be more than 21'}
    ],
    'gameGenre': [
      {type: 'required', message: 'Fiction genre is required'}
    ]
  };

  private fillInForm() {
    this.createGameForm = this.formBuilder.group({
      id: [this.selectedArticle.articleId],
      type: [this.type, Validators.required],
      title: [this.selectedArticle.title, Validators.compose([
        Validators.required, Validators.maxLength(100)
      ])],
      price: [this.selectedArticle.price, Validators.compose([
        Validators.required,Validators.min(0.01), Validators.max(9999.99)
      ])],
      supplierId: [this.selectedArticle.supplierId, Validators.compose([
        Validators.required, Validators.maxLength(100)
      ])],
      publisher: [this.selectedArticle.publisher,  Validators.maxLength(100)
      ],
      minimumAge: [this.selectedArticle.minimumAge, Validators.compose([
        Validators.pattern('[0-9]*'), Validators.min(1), Validators.max(21)
      ])],
      gameGenre: [this.selectedArticle.gameGenre, Validators.required],
    });
  }

}
