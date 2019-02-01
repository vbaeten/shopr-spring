import { Injectable } from '@angular/core';
import {ApiService} from "./api.service";
import {Observable} from "rxjs";
import {Fiction} from "../models/fiction";

@Injectable({
  providedIn: 'root'
})
export class GameService {

  constructor(
    private apiService: ApiService) {
  }

  getGames(): Observable<Fiction[]>{
    return this.apiService.doGet('/game/list');
  }

}
