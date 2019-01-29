import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Game} from "../models/game";

@Injectable({
  providedIn: 'root'
})
export class GameService {

  private classUrl: string = environment.baseApiUrl+'/games';


  constructor(private http: HttpClient) { }




  public createGame(game:Game):Observable<Game>{
    return this.http.post<Game>(this.classUrl,game)

  }


  public getGameById(id:number):Observable<Game>{
    return this.http.get<Game>(this.classUrl+'/'+id)
  }


  getGames():Observable<Game[]>{
    return this.http.get<Game[]>(this.classUrl+'/all');
  }

  public deleteById(id:number):Observable<Game>{
    return this.http.delete<Game>(this.classUrl+'/'+id)
  }

}
