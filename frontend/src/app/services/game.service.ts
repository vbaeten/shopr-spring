import {Injectable} from '@angular/core';
import {Game} from "../models/game";
import {ApiService} from "./api.service";
import {MatSnackBar} from "@angular/material";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class GameService {
  constructor(private notification: MatSnackBar, private apiService: ApiService) {
  }

  public createGame(game: Game) {
    this.apiService.doPost("/game", game).subscribe(response => {
        this.notification.open("New game created", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "Game has not been created, try again! 👎", {duration: 3000});
      })
  };

  public edit(game: Game) {
    this.apiService.doPut("/game", game).subscribe(response => {
        this.notification.open("Game has been updated", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "Game has not been updated, try again! 👎", {duration: 3000});
      })
  }

  public getGames() {
    return this.apiService.doGet("/game")
  }

  public deleteGame(id: number) {
    return this.apiService.doDelete("/game/" + id)
  }

  public getGameById(id: number): Observable<Game> {
    return this.apiService.doGet("/game/" + id);
  }

}
