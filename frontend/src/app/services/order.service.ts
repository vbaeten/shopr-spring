import {Injectable} from '@angular/core';
import {Order} from "../models/order";
import {Observable} from "rxjs";
import {MatSnackBar} from "@angular/material";
import {ApiService} from "./api.service";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private notification: MatSnackBar, private apiService: ApiService) {
  }

  public createOrder(order: Order){
    this.apiService.doPost("/order", order).subscribe(response => {
        this.notification.open("New order created", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "Order has not been created, try again! 👎", {duration: 3000});
      });
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
