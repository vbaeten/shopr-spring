import {Injectable} from '@angular/core';
import {Article} from "../models/article";
import {ApiService} from "./api.service";
import {MatSnackBar} from "@angular/material";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ArticleSevice {
  constructor(private notification: MatSnackBar, private apiService: ApiService) {
  }

  public createArticle(article: Article) {
    this.apiService.doPost("/article", article).subscribe(response => {
        this.notification.open("New article created", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "Article has not been created, try again! 👎", {duration: 3000});
      })
  };

  public edit(article: Article){
    this.apiService.doPut("/article", article).subscribe(response => {
        this.notification.open("article has been updated", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "Article has not been updated, try again! 👎", {duration: 3000});
      })
  }

  public getArticleById(id:number) :Observable<Article>{
      return this.apiService.doGet("/article/" + id);
  }

  public getArticles(): Observable<Article[]> {
    return this.apiService.doGet("/article")
  }

  public deleteArticle(id: number) {
    return this.apiService.doDelete("/article/" + id)
  }



}
