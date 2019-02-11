import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {Observable} from 'rxjs';
import {Fiction} from '../models/fiction';

@Injectable({
  providedIn: 'root'
})
export class FictionService {

  constructor(
    private apiService: ApiService) {
  }

  getFictionBooks(): Observable<Fiction[]> {
    return this.apiService.doGet('/fiction/list');
  }

  addFiction(fiction: Fiction): Observable<Fiction> {
    return this.apiService.doPost('/fiction/add', fiction);
  }

  getFiction(id: number): Observable<Fiction> {
    return this.apiService.doGet('/fiction/' + id);
  }
}
