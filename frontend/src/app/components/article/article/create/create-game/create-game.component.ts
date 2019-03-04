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

    this.gameService.createGame(this.game);

  }

  private fillInForm() {
    this.createGameForm = this.formBuilder.group({
      id: [this.selectedArticle.articleId],
      type: [this.type, Validators.required],
      title: [this.selectedArticle.title, Validators.required],
      price: [this.selectedArticle.price, Validators.required],
      supplierId: [this.selectedArticle.supplierId, Validators.required],
      publisher: [this.selectedArticle.publisher, Validators.required],
      minimumAge: [this.selectedArticle.minimumAge, Validators.required],
      gameGenre: [this.selectedArticle.gameGenre, Validators.required],
    });
  }
}
