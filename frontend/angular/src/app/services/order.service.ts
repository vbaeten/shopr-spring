import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Order} from "../domain/order";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private httpClient: HttpClient) {
  }

  saveOrder(order: Order): Observable<Order> {
    return this.httpClient.put<Order>("/orders/save", order)
  }
}
