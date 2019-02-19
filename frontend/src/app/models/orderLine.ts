import {Article} from "./article";
import {Order} from "./order";


export class OrderLine {

  public quantity: number;
  public article: Article;
  public order: Order;
  public subtotal: number;

  constructor(quantity?: number, article?: Article, order?: Order, subtotal?: number) {
    this.quantity = quantity;
    this.article = article;
    this.order = order;
    this.subtotal = subtotal;
  }
}
