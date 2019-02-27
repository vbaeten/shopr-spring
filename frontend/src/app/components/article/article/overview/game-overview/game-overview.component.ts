import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {Game} from "../../../../../models/game";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {GameService} from "../../../../../services/game.service";
import {Router} from "@angular/router";
import {ArticleService} from "../../../../../services/article.service";

@Component({
  selector: 'app-game-overview',
  templateUrl: './game-overview.component.html',
  styleUrls: ['./game-overview.component.css']
})
export class GameOverviewComponent implements OnInit {
  @Input() type: string;
  selectedArticle: Game;
  displayedColumns: string[] = ['articleId', 'title', 'price', 'supplierId', 'type', 'delete', 'details'];
  dataSource = new MatTableDataSource<Game>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private gameService: GameService, private articleService: ArticleService, private router: Router) {
  }

  ngOnInit() {
    this.getAllGames();
  }

  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  getAllGames = () => {
    this.gameService.getGames()
      .subscribe(data => {
        this.dataSource.data = data as Game[];
      })
  };

  deleteGame = (id: number) => {
    this.articleService.deleteArticle(id).subscribe(() => {
      this.getAllGames();
    });
  };

  getGameById(id: number) {
    this.gameService.getGameById(id)
  }

  goToDetailsPage(game: Game) {
    this.router.navigate(["/article/game-details/", game.articleId]);
    sessionStorage.setItem('selectedArticle', JSON.stringify(game))
  }


  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }


}
