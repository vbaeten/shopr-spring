import {OrderLine} from './order-line';
import {User} from './user';

export class Order {
  public id: number;
  public user: User;
  public orderDate: Date;
  public orderLines: OrderLine[];
  public total: number;


  constructor(id?: number, user?: User, orderDate?: Date, orderLines?: OrderLine[], total?: number) {
    this.id = id;
    this.user = user;
    this.orderDate = orderDate;
    this.orderLines = orderLines;
    this.total = total;
  }
}
