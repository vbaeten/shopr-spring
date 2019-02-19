import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Item} from "../models/item";


@Injectable({
  providedIn: 'root'
})
export class ItemsService {

  private classUrl: string = environment.baseApiUrl+'/items';


  constructor(private http: HttpClient) { }

  getItems():Observable<Item[]>{
    return this.http.get<Item[]>(this.classUrl);
  }

  public getItemById(id:number):Observable<Item>{
    return this.http.get<Item>(this.classUrl+'/'+id)
  }


}
