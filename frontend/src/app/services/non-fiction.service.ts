import { Injectable } from '@angular/core';
import {ApiService} from './api.service';
import {Observable} from 'rxjs';
import {NonFiction} from '../models/non-fiction';

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

}
