import {Component, OnInit} from '@angular/core';
import {ArticleService} from "../../services/article.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  article: any;
  articleId: number;

  constructor(private articleService: ArticleService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.articleId = this.route.snapshot.params['articleId'];
    // this.route.params.subscribe(params => this.articleId = params['articleId']);
    this.articleService.getArticleById(this.articleId).subscribe(article => this.article = article);
  }

}
