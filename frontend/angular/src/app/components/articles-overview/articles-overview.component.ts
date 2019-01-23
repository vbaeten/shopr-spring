import {Component, OnInit} from '@angular/core';
import {ArticleService} from "../../services/article.service";
import {Article} from "../../domain/Article";

@Component({
  selector: 'app-articles-overview',
  templateUrl: './articles-overview.component.html',
  styleUrls: ['./articles-overview.component.css']
})
export class ArticlesOverviewComponent implements OnInit {

  articles:Article[];
  constructor(private articlesService: ArticleService) {
  }

  ngOnInit() {
    this.articlesService.allArticles().subscribe((article2:Article[]) => this.articles = article2);
  }

}
