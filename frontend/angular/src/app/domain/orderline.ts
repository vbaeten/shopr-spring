import {Article} from "./article";

export class Orderline {
  article: Article;
  subTotal: number;
  quantity: number;
  orderlineId: number;

  constructor(article?: Article, subtotal?: number, quantity?: number, orderlineId?: number) {
    this.article = article;
    this.subTotal = subtotal;
    this.quantity = quantity;
    this.orderlineId = orderlineId;
  }
}

