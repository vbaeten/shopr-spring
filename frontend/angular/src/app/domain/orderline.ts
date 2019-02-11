import {Article} from "./article";

export class Orderline {
  article: Article;
  quantity: number;
  subTotal: number;
  orderlineId?: number;

  constructor(article?: Article, quantity?: number, subtotal?: number, orderlineId?: number) {
    this.article = article;
    this.quantity = quantity;
    this.subTotal = this.article.price * this.quantity;
    this.orderlineId = orderlineId;
  }
}

