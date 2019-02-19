import {User} from './user';
import {Order} from './order';
import {Article} from './article';
import {Cart} from "./cart";

export class OrderLine {
  public id: number;
  public article: Article;
  public quantity: number;
  public order: Order;
  public user: User;
  public subTotal: number;
  public cart: Cart;


  constructor(id?: number, article?: Article, quantity?: number, order?: Order, user?: User, subTotal?: number, cart?: Cart) {
    this.id = id;
    this.article = article;
    this.quantity = quantity;
    this.order = order;
    this.user = user;
    this.subTotal = subTotal;
    this.cart = cart;
  }
}

