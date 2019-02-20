import {Injectable} from '@angular/core';
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

  addNonFiction(fiction: NonFiction): Observable<NonFiction> {
    return this.apiService.doPost('/nonfiction/add', fiction);
  }

  getNonFiction(id: number): Observable<NonFiction> {
    return this.apiService.doGet('/nonfiction/' + id);
  }
}
