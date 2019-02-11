import { Injectable } from '@angular/core';
import {ApiService} from './api.service';
import {Observable} from 'rxjs';
import {NonFiction} from '../models/non-fiction';
import {User} from "../models/user";
import {Fiction} from "../models/fiction";

@Injectable({
  providedIn: 'root'
})
export class NonFictionService {


  constructor(
    private apiService: ApiService) {
  }

  getNonFictionBooks(): Observable<NonFiction[]> {
    return this.apiService.doGet('/nonfiction/list');
  }

  addNonFiction(fiction: Fiction): Observable<NonFiction> {
    return this.apiService.doPost('nonfiction/add', fiction);
  }

  getNonFiction(id: number): Observable<NonFiction> {
    return this.apiService.doGet('/nonfiction/' + id);
  }
}
