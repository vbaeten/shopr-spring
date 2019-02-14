import {User} from './user';
import {Order} from './order';
import {Article} from './article';

export class OrderLine {
  public id: number;
  public article: Article;
  public quantity: number;
  public order: Order;
  public user: User;


  constructor(id?: number, article?: Article, quantity?: number, order?: Order, user?: User) {
    this.id = id;
    this.article = article;
    this.quantity = quantity;
    this.order = order;
    this.user = user;
  }
}

