import {Component, OnInit} from '@angular/core';
import {Game} from '../../../../models/game';
import {GameService} from '../../../../services/game.service';
import {ArticleService} from '../../../../services/article.service';

@Component({
  selector: 'app-game-overview',
  templateUrl: './game-overview.component.html',
  styleUrls: ['./game-overview.component.css']
})
export class GameOverviewComponent implements OnInit {

  games: Game[] = [];
  dataSource;
  displayedColumns: string[] = ['id', 'title', 'price', 'delete'];


  constructor(private gameService: GameService, private articleService: ArticleService) {
  }

  ngOnInit() {
    this.refresh();
  }

  deleteArticle(id: number): void {
    this.articleService.deleteArticleById(id).subscribe(data => this.refresh());
  }

  refresh() {
    this.gameService.getGames().subscribe(
      data => {
        this.games = data;
        this.dataSource = this.games;
      }
    );
  }
}
