import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Article} from "../domain/Article";

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor(private httpClient: HttpClient) {
  }

  private articleList: Article[];

  allArticles(): Observable<Article[]> {
    let articlesObservable = this.httpClient.get<Article[]>("/articles/all");
    articlesObservable.subscribe(response => {
      this.articleList = response;
    });
    return articlesObservable;
  }

  getArticleById(articleId: number): Observable<Article> {
    return this.httpClient.get<Article>("/articles/" + articleId);
  }

}
