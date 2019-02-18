import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {OrderLine} from '../models/order-line';
import {Observable} from 'rxjs';
import {User} from '../models/user';
import {Order} from "../models/order";
import {Cart} from "../models/cart";

@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {

  constructor(private apiService: ApiService) { }

  addToCart(orderLine: OrderLine): Observable<OrderLine> {
    console.log(orderLine);
    return this.apiService.doPost('/cart/add', orderLine);
  }

  sendToOrder(order: Order): Observable<Order> {
    return this.apiService.doPost('/order/send', order);
  }

  findByUser(user: User): Observable<OrderLine[]> {
    return this.apiService.doGet('/cart/' + user);
  }

  findCurrentCartByOrderLinesByUserId(id: number): Observable<OrderLine[]> {
    return this.apiService.doGet('/orderline/current/' + id);
  }

  createCart(cart: Cart): Observable<Cart> {
    return this.apiService.doPost('/cart/create', cart);
  }

  loadCart(userId: number): Observable<Cart> {
    return this.apiService.doGet('/cart/' + userId);
  }

  deleteOrderLineById(id: number): Observable<OrderLine> {
    return this.apiService.doDelete('/cart/delete/' + id);
  }

  setOrderLinesToOrder(orderLine: OrderLine): Observable<OrderLine> {
    return this.apiService.doPut('/cart/line', orderLine);
  }
}
