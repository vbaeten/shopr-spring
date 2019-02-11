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

  addGame(game: Game): Observable<Game> {
    return this.apiService.doPost('/game/add', game);
  }

  deleteGame(game: Game): Observable<Game> {
    return this.apiService.doDelete('/game/delete');
  }

  deleteGameById(id: number): Observable<Game> {
    return this.apiService.doDelete('/game/delete/' + id);
  }

  getGame(id: number): Observable<Game> {
    return this.apiService.doGet('/game/' + id);
  }

}
