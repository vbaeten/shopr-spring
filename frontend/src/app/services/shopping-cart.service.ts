import { Injectable } from '@angular/core';
import {ApiService} from './api.service';
import {Article} from '../models/article';
import {OrderLine} from '../models/order-line';
import {Observable} from 'rxjs';
import {User} from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {

  constructor(private apiService: ApiService) { }

  addToCart(orderLine: OrderLine): Observable<OrderLine> {
    return this.apiService.doPost('/cart/add', orderLine);
  }

  findByUser(user: User): Observable<OrderLine[]> {
    return this.apiService.doGet('/cart/' + user);
  }

  findByUserId(id: number): Observable<OrderLine[]> {
    return this.apiService.doGet('/cart/list/' + id);
  }
}
