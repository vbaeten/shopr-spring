import { Component, OnInit } from '@angular/core';

import {Article} from '../../../../models/article';
import {ArticleService} from '../../../../services/article.service';

@Component({
  selector: 'app-article-overview',
  templateUrl: './article-overview.component.html',
  styleUrls: ['./article-overview.component.css']
})
export class ArticleOverviewComponent implements OnInit {

  articles: Article[] = [];

  constructor(private articleService: ArticleService) { }

  columns: string[] = ['id', 'title', 'price'];

  ngOnInit() {
    this.articleService.getArticles().subscribe(datasource => this.articles = datasource);
  }

}
