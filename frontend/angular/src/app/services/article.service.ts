import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor(private httpClient:HttpClient) { }

  allArticles() {
    return this.httpClient.get("/articles/all");
  }

}
