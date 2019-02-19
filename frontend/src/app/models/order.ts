import {User} from "./user";
import {OrderLine} from "./orderLine";

export class Order {
  public orderId;
  public dateOfOrder: Date;
  public user: User;
  public confirmed: boolean;
  public orderLines: OrderLine[];

  constructor(dateOfOrder?: Date, user?: User, confirmed?: boolean) {
    this.dateOfOrder = dateOfOrder;
    this.user = user;
    this.confirmed = confirmed;
  }
}
