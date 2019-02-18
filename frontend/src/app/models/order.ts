import {OrderLine} from './order-line';
import {Time} from '@angular/common';
import {User} from './user';

export class Order {
  public id: number;
  public user: User;
  public orderDate: Date;
  public orderLines: OrderLine[];


  constructor(id?: number, user?: User, orderDate?: Date, orderLines?: OrderLine[]) {
    this.id = id;
    this.user = user;
    this.orderDate = orderDate;
    this.orderLines = orderLines;
  }
}
