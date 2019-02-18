import {Component, OnInit} from '@angular/core';
import {GameService} from "../../services/game.service";
import {ArticleService} from "../../services/article.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Game} from "../../domain/game";
import {MatSnackBar} from "@angular/material";

@Component({
  selector: 'app-editgame',
  templateUrl: './editgame.component.html',
  styleUrls: ['./editgame.component.css']
})
export class EditgameComponent implements OnInit {
  gameGenres: string[];
  game: Game;

  constructor(private snackBar: MatSnackBar, private gameservice: GameService, private articleservice: ArticleService, public router: Router, private route: ActivatedRoute) {
  }

  viewSnackBar() {
    let message = 'Your game has been successfully updated in Shopr.';
    let action = '';
    this.articleservice.getSnackBar(message, action)
  }
  ngOnInit() {
    this.gameservice.getGameGenres().subscribe(gameGenres => this.gameGenres = gameGenres)
    this.route.params.subscribe((params) => {
      this.articleservice.getArticleById(params['articleId']).subscribe(data => this.game = data)
    })
  }

  edit() {
    this.gameservice.updateGame(this.game).subscribe(
      () => {
        this.viewSnackBar();
        this.router.navigate(['/articles'])
      },
      error1 => {
        alert("edit failed")
      },
    );
  }
}
