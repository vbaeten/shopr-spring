import { Injectable } from '@angular/core';
import {ApiService} from './api.service';
import {Observable} from 'rxjs';
import {Lp} from '../models/lp';

@Injectable({
  providedIn: 'root'
})
export class LpService {

  constructor(
    private apiService: ApiService) {
  }

  getLps(): Observable<Lp[]> {
    return this.apiService.doGet('/lp/list');
  }

  addLp(lp: Lp): Observable<Lp> {
    return this.apiService.doPost('/lp/add', lp);
  }

  getLp(id: number): Observable<Lp> {
    return this.apiService.doGet('/lp/' + id);
  }

}
