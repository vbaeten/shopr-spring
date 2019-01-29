import {Article} from "./Article";

export class Book extends Article {
  constructor(public title: string,
              public type: string,
              public price: number,
              public supplierId: string,
              public author: string,
              public isbn: string,
              public numberOfPages: number,
              public articleId?: string,) {
    super(title, type, price, supplierId, articleId)
  }
}
