import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Lp} from "../models/lp";


@Injectable({
  providedIn: 'root'
})
export class LpService {

  private classUrl: string = environment.baseApiUrl+'/lps';


  constructor(private http: HttpClient) { }

  public createLp(lp:Lp):Observable<Lp>{
    return this.http.post<Lp>(this.classUrl,lp)

  }

  getLp():Observable<Lp[]>{
    return this.http.get<Lp[]>(this.classUrl);
  }
}
