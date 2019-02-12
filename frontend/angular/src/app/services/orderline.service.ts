import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Orderline} from "../domain/orderline";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class OrderlineService {

  constructor(private httpClient: HttpClient) {
  }

  getOrderLines(): Observable<Orderline[]> {
    return this.httpClient.get<Orderline[]>("/orderlines/all")
  }

  createOrderLine(orderline: Orderline): Observable<Orderline> {
    return this.httpClient.post<Orderline>("/orderlines/add", orderline)
  }

  deleteOrderlineById(orderlineId: number): Observable<Orderline> {
    return this.httpClient.delete<Orderline>("/orderlines/" + orderlineId);
  }

  getOrderlineById(orderlineId: number): Observable<Orderline> {
    return this.httpClient.get<Orderline>("/orderlines/" + orderlineId);
  }
}
