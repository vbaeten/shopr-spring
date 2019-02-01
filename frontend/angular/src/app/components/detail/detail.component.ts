import {Component, OnInit} from '@angular/core';
import {ArticleService} from "../../services/article.service";
import {Article} from "../../domain/Article";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  article: Article;
  articleId: number;

  constructor(private service: ArticleService) {
  }

  ngOnInit() {
    this.service.getArticleById(this.articleId);
  }

}
