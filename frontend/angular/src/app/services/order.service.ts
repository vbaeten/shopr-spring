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

  private orderList: Order[];

  saveOrder(order: Order): Observable<Order> {
    return this.httpClient.put<Order>("/orders/save", order)
  }

  findCurrentCartByUserId(userId: number): Observable<Order> {
    return this.httpClient.get<Order>(`/orders/findCurrentCartByUserId/${userId}`)
  }

  orderNow(order: Order): Observable<Order> {
    return this.httpClient.put<Order>("/orders/ordernow", order);
  }

  allOrders(userId: number): Observable<Order[]> {
    let ordersObservable = this.httpClient.get<Order[]>(`/orders/all/${userId}`);
    ordersObservable.subscribe(response => {
      this.orderList = response;
    });
    return ordersObservable;
  }


}
