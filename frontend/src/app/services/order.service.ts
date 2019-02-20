import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {Order} from '../models/order';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private apiService: ApiService) { }

  sendToOrder(order: Order): Observable<Order> {
    return this.apiService.doPost('/order/send', order);
  }

  findOrdersByUserId(id: number): Observable<Order[]> {
    return this.apiService.doGet('/order/list/' + id);
  }
}
