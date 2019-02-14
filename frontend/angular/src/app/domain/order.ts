import {Orderline} from "./orderline";

export class Order {
  orderStatus: string;
  userId: number;
  orderlines: Orderline[];
  orderId?: number;

  constructor(orderStatus?: string, userId?: number, orderlines?: Orderline[], orderId?: number) {
    this.orderStatus = orderStatus;
    this.userId = userId;
    this.orderlines = orderlines;
    this.orderId = orderId;
  }
}
