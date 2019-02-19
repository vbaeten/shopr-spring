import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {OrderLine} from '../models/order-line';
import {Observable, Subject} from 'rxjs';
import {User} from '../models/user';
import {Order} from '../models/order';
import {Cart} from '../models/cart';

@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {

  orderLineAddedSubject = new Subject<OrderLine>();
  orderLineDeletedSubject = new Subject<OrderLine>();

  constructor(private apiService: ApiService) { }

  addToCart(orderLine: OrderLine) {
    console.log(orderLine);
    this.apiService.doPost('/cart/add', orderLine).subscribe(data => {
      this.orderLineAddedSubject.next(data);
    });
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

  deleteOrderLineById(id: number): Observable<OrderLine> {
    return this.apiService.doDelete('/cart/delete/' + id);
  }

  deleteOrderLine(id: number) {
    this.apiService.doDelete('/cart/delete/' + id).subscribe(data => {
      this.orderLineDeletedSubject.next(data);
    });
  }

  setOrderLinesToOrder(orderLine: OrderLine): Observable<OrderLine> {
    return this.apiService.doPut('/cart/line', orderLine);
  }
}
