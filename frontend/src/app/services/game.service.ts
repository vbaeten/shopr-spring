import { Injectable } from '@angular/core';
import {ApiService} from './api.service';
import {Observable} from 'rxjs';
import {Game} from '../models/game';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  constructor(
    private apiService: ApiService) {
  }

  getGames(): Observable<Game[]> {
    return this.apiService.doGet('/game/list');
  }

}
