import {Injectable} from '@angular/core';
import {MatSnackBar} from "@angular/material";
import {ApiService} from "./api.service";
import {OrderLine} from "../models/orderLine";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class OrderLineService {

  constructor(private notification: MatSnackBar, private apiService: ApiService) {
  }

  public createOrderLine(orderLine: OrderLine): Observable<OrderLine> {
    let orderLineObservable = Object.assign(new Observable<OrderLine>(), this.apiService.doPost("/orderLine", orderLine));
    orderLineObservable.subscribe(response => {
        this.notification.open("product added to shopping cart", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "product has not been added to shopping cart, try again! 👎", {duration: 3000});
      });
    return orderLineObservable;
  };

  public edit(orderLine: OrderLine) {
    this.apiService.doPut("/orderLine", orderLine).subscribe(response => {
        this.notification.open("Shopping cart has been updated", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "Shopping cart has not been updated, try again! 👎", {duration: 3000});
      })
  }

  public getOrderLines(): Observable<OrderLine[]> {
    return this.apiService.doGet("/orderLine")
  }

  public deleteOrderLine(id: number) {
    return this.apiService.doDelete("/orderLine/" + id)
  }

  public getOrderLinesByOrderId(id: number): Observable<OrderLine[]> {
    return this.apiService.doGet(`/orderLine/order/${id}`);
  }

  addOrderLineToCartLocalStorage(cart: OrderLine[], newOrderLine: OrderLine) {
    let orderLine = cart.find(orderLine => orderLine.article.articleId === newOrderLine.article.articleId);
    if (orderLine) {
      orderLine.quantity = +newOrderLine.quantity + +orderLine.quantity;
      orderLine.subtotal = orderLine.quantity * orderLine.article.price;
    } else {
      cart.push(newOrderLine);
    }
    localStorage.setItem("cart", JSON.stringify(cart));
    this.notification.open('You have added ' + newOrderLine.quantity + " article(s) to shopping cart"
      , "👍", {duration: 3000})
  }

  getCartFromStorage(): OrderLine[] {
    return JSON.parse(localStorage.getItem("cart"));
  }

  setCartToStorage(shoppingCart: OrderLine[]) {
    localStorage.setItem('cart', JSON.stringify(shoppingCart))
  }

  getCurrentOrderLineFromStorage(): OrderLine {
    return JSON.parse(localStorage.getItem("currentOrder"));
  }

  deleteCartFromStorage() {
    localStorage.removeItem('cart');
  }


}
