import {Orderline} from "./orderline";
import {User} from "./user";
import {OrderStatus} from "./orderStatus";

export class Order {
  orderStatus: OrderStatus;
  user: User;
  orderlineList?: Orderline[];
  orderId?: number;
  price?: number;

  constructor(orderStatus: OrderStatus, user: User, orderlineList?: Orderline[], orderId?: number) {
    this.orderStatus = orderStatus;
    this.user = user;
    this.orderlineList = orderlineList;
    this.orderId = orderId;
  }
}
