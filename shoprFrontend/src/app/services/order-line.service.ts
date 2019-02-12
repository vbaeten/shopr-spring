import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Orderline} from "../models/Orderline";
import {Game} from "../models/game";

@Injectable({
  providedIn: 'root'
})
export class OrderLineService {

  private classUrl: string = environment.baseApiUrl+'/orderLines';


  constructor(private http: HttpClient) { }


  public createOrderLine(orderLine:Orderline):Observable<Orderline>{
    return this.http.post<Orderline>(this.classUrl,orderLine)
  }


  getOrderLines():Observable<Orderline[]>{
    return this.http.get<Orderline[]>(this.classUrl);
  }


  deleteById(id:number):Observable<Orderline>{
    return this.http.delete<Orderline>(this.classUrl+'/'+id)
  }

}
