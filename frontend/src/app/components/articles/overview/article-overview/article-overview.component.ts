import {Component, OnInit, ViewChild} from '@angular/core';

import {Article} from '../../../../models/article';
import {ArticleService} from '../../../../services/article.service';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSort} from '@angular/material';

@Component({
  selector: 'app-article-overview',
  templateUrl: './article-overview.component.html',
  styleUrls: ['./article-overview.component.css']
})
export class ArticleOverviewComponent implements OnInit {

  articles: Article[] = [];
  article: Article;
  dataSource;
  displayedColumns: string[] = ['id', 'title', 'price', 'type', 'detail'];

  // @ViewChild(MatSort) sort: MatSort;

  constructor(private articleService: ArticleService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.articleService.getArticles().subscribe(data => {
      this.articles = data;
      this.dataSource = this.articles;
    });
    // this.dataSource.sort = this.sort;
  }

  goToDetails(article: Article) {
    switch (article.type) {
      case 'Game': {
        this.router.navigate(['/game', article.id]);
        break;
      }
      case 'Lp': {
        this.router.navigate(['/lp', article.id]);
        break;
      }
      case 'Fiction': {
        this.router.navigate(['/fiction', article.id]);
        break;
      }
      case 'Non-Fiction': {
        this.router.navigate(['/nonfiction', article.id]);
        break;
      }
    }
  }
}
