import {Injectable} from '@angular/core';
import {Order} from "../models/order";
import {Observable, Subject} from "rxjs";
import {MatSnackBar} from "@angular/material";
import {ApiService} from "./api.service";
import {OrderLineService} from "./order-line.service";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private orderLineService: OrderLineService, private notification: MatSnackBar, private apiService: ApiService) {
  }

  public createOrder(order: Order): Observable<boolean> {
    const processing: Subject<boolean> = new Subject();
    this.apiService.doPost("/order", order).subscribe(response => {
        localStorage.removeItem('cart');
        processing.next(true);
        this.notification.open("Order has been completed", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "Order has not been completed, try again! 👎", {duration: 3000});
      },);
    return processing.asObservable();
  };

  public edit(order: Order) {
    this.apiService.doPut("/order", order).subscribe(response => {
        this.notification.open("order has been updated", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "Order has not been updated, try again! 👎", {duration: 3000});
      })
  }

  public getOrders(): Observable<Order[]> {
    return this.apiService.doGet("/order")
  }

  public deleteOrder(id: number) {
    return this.apiService.doDelete("/order/" + id)
  }

  public getOrderById(id: number): Observable<Order> {
    return this.apiService.doGet("/order/" + id)
  }

  // getCurrentOrderFromStorage(): Order {
  //   return JSON.parse(localStorage.getItem("currentOrder"));
  // }
  //
  // setCurrentOrderToStorage(order: Order) {
  //   if (this.getCurrentOrderFromStorage() === null) {
  //     this.createOrder(order).subscribe(newOrder => {
  //       localStorage.setItem('currentOrder', JSON.stringify(newOrder));
  //     });
  //   }
  // }

}
