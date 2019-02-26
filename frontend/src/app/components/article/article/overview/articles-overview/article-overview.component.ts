import {AfterViewInit, Component, Input, OnInit, ViewChild} from '@angular/core';
import {ArticleService} from "../../../../../services/article.service";
import {Article} from "../../../../../models/article";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {Router} from "@angular/router";

@Component({
  selector: 'app-article-overview',
  templateUrl: './article-overview.component.html',
  styleUrls: ['./article-overview.component.css']
})
export class ArticleOverviewComponent implements OnInit, AfterViewInit {
  @Input() type: string;

  selectedArticle: Article;
  displayedColumns: string[] = ['articleId', 'title', 'price', 'supplierId', 'type', 'delete', 'details'];
  dataSource = new MatTableDataSource<Article>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private articleService: ArticleService, private router: Router) {
  }

  ngOnInit() {
    this.getAllArticles();
  }

  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  getAllArticles = () => {
    this.articleService.getArticles()
      .subscribe(data => {
        this.dataSource.data = data as Article[];
      })
  };

  deleteArticle = (id: number) => {
    this.articleService.deleteArticle(id).subscribe(() => {
      this.getAllArticles();
    });
  };

  goToDetailsPage(article: Article) {
    switch (article.type) {
      case "game": {
        this.router.navigate(["/article/game-details/", article.articleId])
      }
        break;
      case "lp": {
        this.router.navigate(["/article/lp-details/", article.articleId])
      }
        break;
      case "fiction": {
        this.router.navigate(["/article/fiction-details/", article.articleId])
      }
        break;
      case "nonFiction": {
        this.router.navigate(["/article/nonFiction-details/", article.articleId])
      }
        break;
    }
    this.articleService.setArticleToStorage(article);
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }


}

