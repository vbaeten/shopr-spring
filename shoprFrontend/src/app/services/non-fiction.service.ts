import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {NonFiction} from "../models/nonFiction";

@Injectable({
  providedIn: 'root'
})
export class NonFictionService {

  private classUrl: string = environment.baseApiUrl+'/nonFictionBooks';



  constructor(private http: HttpClient) { }

  public createNonFiction(nonFiction:NonFiction):Observable<NonFiction>{
    return this.http.post<NonFiction>(this.classUrl,nonFiction)

  }

  getNonFictions():Observable<NonFiction[]>{
    return this.http.get<NonFiction[]>(this.classUrl+'/all');
  }

  public getById(id:number):Observable<NonFiction>{
    return this.http.get<NonFiction>(this.classUrl+'/'+id)
  }

  public deleteById(id:number):Observable<NonFiction>{
    return this.http.delete<NonFiction>(this.classUrl+'/'+id)
  }

}
