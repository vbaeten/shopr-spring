import {Component, OnInit} from '@angular/core';
import {GameService} from "../../services/game.service";
import {ArticleService} from "../../services/article.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Game} from "../../domain/Game";

@Component({
  selector: 'app-editgame',
  templateUrl: './editgame.component.html',
  styleUrls: ['./editgame.component.css']
})
export class EditgameComponent implements OnInit {
  gameGenres: string[];
  game: Game;

  constructor(private gameservice: GameService, private articleservice: ArticleService, public router: Router, private route: ActivatedRoute) {
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
        this.router.navigate(['/articles'])
      },
      error1 => {
        alert("edit failed")
      },
    );
  }
}
