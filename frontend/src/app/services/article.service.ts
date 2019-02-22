import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {Observable} from 'rxjs';
import {Article} from '../models/article';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor(
    private apiService: ApiService) {
  }

  getArticles(): Observable<Article[]> {
    return this.apiService.doGet('/article/list');
  }

  getArticleById(id: number): Observable<Article> {
    return this.apiService.doGet('/article/' + id);
  }

  deleteArticleById(id: number): Observable<Article> {
    return this.apiService.doDelete('/article/delete/' + id);
  }
}
