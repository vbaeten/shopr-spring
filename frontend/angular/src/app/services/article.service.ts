import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
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

  deleteArticleById(articleId: number): void {
    this.httpClient.delete("/articles/detail" + articleId);

  }

  getArticleById(articleId: number): Observable<any> {
    let subject: Subject<any> = new Subject();
    this.httpClient.get("/articles/" + articleId).subscribe((article: Article) => {
      switch (article.type) {
        case "game":
          return this.httpClient.get("/game/" + articleId).subscribe(response => subject.next(response));
        case "lp":
          return this.httpClient.get("/lp/" + articleId).subscribe(response => subject.next(response));
        case "bookfiction":
          return this.httpClient.get("/bookfiction/" + articleId).subscribe(response => subject.next(response));
        case "booknonfiction":
          return this.httpClient.get("/booknonfiction/" + articleId).subscribe(response => subject.next(response));
      }
    });
    return subject.asObservable();

  }
}

