import {Injectable} from '@angular/core';
import {Game} from "../domain/Game";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class GameService {

  constructor(private httpClient: HttpClient) { }

  createGame(game: Game): Observable<Game>{
    return this.httpClient.post<Game>("/game/create", game);
  }

  getGameGenres(): Observable <string[]> {
    return this.httpClient.get<string[]>("/game/genres");
  }
}
