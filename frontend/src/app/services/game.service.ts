import {Injectable} from '@angular/core';
import {Game} from "../models/game";
import {ApiService} from "./api.service";
import {MatSnackBar} from "@angular/material";

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

  public getGames(): Promise<Game[]> {
    return this.apiService.doGet("/game")
      .toPromise()
      .catch(error => GameService.handleError(error))
  }

  private static handleError(error: any): Promise<any> {
    return Promise.reject(error.message | error);
  }
}
