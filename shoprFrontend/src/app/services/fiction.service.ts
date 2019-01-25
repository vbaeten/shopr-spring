import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Fiction} from "../models/fiction";

@Injectable({
  providedIn: 'root'
})
export class FictionService {

  private classUrl: string = environment.baseApiUrl+'/fictionBooks';


  constructor(private http: HttpClient) { }



  public createFiction(fiction:Fiction):Observable<Fiction>{
    return this.http.post<Fiction>(this.classUrl,fiction)

  }

  getFictions():Observable<Fiction[]>{
    return this.http.get<Fiction[]>(this.classUrl);
  }
}
