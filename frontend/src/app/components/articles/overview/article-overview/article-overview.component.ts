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
  dataSource;
  displayedColumns: string[] = ['id', 'title', 'price', 'type'];

  constructor(private articleService: ArticleService) { }

  ngOnInit() {
    this.articleService.getArticles().subscribe(data => {
      this.articles = data;
      this.dataSource = this.articles;
    });
  }

  // ngOnInit() {
  //   this.userService.getUsers().subscribe(data => {
  //     this.users = data;
  //     this.dataSource = this.users;
  //   });
  // }

}
