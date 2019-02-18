import {Component, OnInit} from '@angular/core';
import {GameService} from "../../services/game.service";
import {Game} from "../../domain/game";
import {Router} from "@angular/router";
import {ArticleService} from "../../services/article.service";


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

  constructor(private gameservice: GameService, private articleservice: ArticleService, public router: Router) {

  }
  ngOnInit() {
    this.gameservice.getGameGenres().subscribe(gameGenres => this.gameGenres = gameGenres);
  }

  viewSnackBar() {
    let message = 'Your lp had been successfully added to Shopr.';
    let action = '';
    this.articleservice.getSnackBar(message, action)
  }
  submit() {
    let newGame = new Game(this.title, 'game', this.price, this.supplierId, this.gameGenre, this.minimumAge, this.publisher);
    this.gameservice.createGame(newGame).subscribe(
      result => {
        this.articleservice.allArticles();
        this.viewSnackBar();
        this.router.navigate(['/articles']);
      },
      error1 => {
        alert("create failed")
      },
    )

  }


}
