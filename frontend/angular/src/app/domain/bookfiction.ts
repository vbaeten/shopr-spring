import {Book} from "./book";

export class Bookfiction extends Book {
  constructor(public title: string,
              public type: string,
              public price: number,
              public supplierId: string,
              public author: string,
              public isbn: string,
              public numberOfPages: number,
              public bookfictionGenre: string,
              public summary: string,
              public articleId?: string,) {

    super(title, type, price, supplierId, author, isbn, numberOfPages)
  }
}
