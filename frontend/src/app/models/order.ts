import {OrderLine} from './order-line';
import {Time} from '@angular/common';
import {User} from './user';

export class Order {
  public id: number;
  public user: User;
  public orderDate: Date;


  constructor(id?: number, user?: User, orderDate?: Date) {
    this.id = id;
    this.user = user;
    this.orderDate = orderDate;
  }
}
