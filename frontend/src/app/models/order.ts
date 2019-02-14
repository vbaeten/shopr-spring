import {OrderLine} from './order-line';
import {Time} from '@angular/common';
import {User} from "./user";

export class Order {
  public id: number;
  public user: User;
  public orderLines: OrderLine[];
  public orderDate: Time;


  constructor(id?: number, user?: User, orderLines?: OrderLine[], orderDate?: Time) {
    this.id = id;
    this.user = user;
    this.orderLines = orderLines;
    this.orderDate = orderDate;
  }
}
