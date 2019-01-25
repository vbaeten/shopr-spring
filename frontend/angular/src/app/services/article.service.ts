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

  allArticles(): Observable<Article[]> {
    return this.httpClient.get<Article[]>("/articles/all");
  }

}
