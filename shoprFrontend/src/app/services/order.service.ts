import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Order} from "../models/Order";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private classUrl: string = environment.baseApiUrl+'/orders';


  constructor(private http: HttpClient) { }




  public createOrder(order:Order):Observable<Order>{
    return this.http.post<Order>(this.classUrl,order)
  }



}
