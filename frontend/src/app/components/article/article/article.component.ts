import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {ArticleSevice} from "../../../services/article.sevice";
import {Article} from "../../../models/article";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit, AfterViewInit {

  selectedArticle: Article;
  displayedColumns: string[] = ['articleId', 'title', 'price', 'supplierId', 'type', 'delete'];
  dataSource = new MatTableDataSource<Article>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private articleService: ArticleSevice, private router: Router, private route: ActivatedRoute) {
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
    this.articleService.deleteArticle(id).subscribe(()=> {
      this.getAllArticles();
    });
  };

  getArticleById(id: number){
    this.articleService.getArticleById(id)
  }

  goToDetailsPage(article:Article){
    switch (article.type) {
      case "game": {
        this.router.navigate(["/article/game-details/", article.articleId],
          { relativeTo: this.route })
      } break;
      case "lp": {
        this.router.navigate(["/article/lp-details/", article.articleId],
          { relativeTo: this.route })
      } break;
      case "fiction": {
        this.router.navigate(["/article/fiction-details/", article.articleId],
          { relativeTo: this.route })
      } break;
      case "nonFiction": {
        this.router.navigate(["/article/nonFiction-details/", article.articleId],
          { relativeTo: this.route })
      } break;
    }

      sessionStorage.setItem('selectedArticle', JSON.stringify(article))
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }


}

