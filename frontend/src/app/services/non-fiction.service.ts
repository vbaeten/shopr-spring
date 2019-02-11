import { Injectable } from '@angular/core';
import {ApiService} from './api.service';
import {Observable} from 'rxjs';
import {NonFiction} from '../models/non-fiction';
import {User} from "../models/user";

@Injectable({
  providedIn: 'root'
})
export class NonFictionService {

  constructor(
    private apiService: ApiService, private OrderService) {
  }

  getNonFictionBooks(): Observable<NonFiction[]> {
    return this.apiService.doGet('/nonfiction/list');
  }

  addNonFiction(nonFiction: NonFiction) {
    return this.apiService.doPost('/nonfiction/add', nonFiction);
  }

  deleteFiction(id: number): Observable<NonFiction> {
    return this.apiService.doDelete('/nonfiction/delete/' + id);
  }

  getNonFiction(id: number): Observable<NonFiction> {
    return this.apiService.doGet('/nonfiction/' + id);
  }

  addToCart(id: number): void {

  }
}
