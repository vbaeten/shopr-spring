import {OrderLine} from './order-line';
import {Time} from '@angular/common';
import {User} from './user';

export class Order {
  public id: number;
  public userId: number;
  public orderDate: Date;


  constructor(id?: number, userId?: number, orderDate?: Date) {
    this.id = id;
    this.userId = userId;
    this.orderDate = orderDate;
  }
}
