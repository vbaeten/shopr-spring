import {Book} from "./book";

export class Booknonfiction extends Book {
  constructor(public title: string,
              public type: string,
              public price: number,
              public supplierId: string,
              public author: string,
              public isbn: string,
              public numberOfPages: number,
              public booknonfictionGenre: string,
              public articleId?: string,) {

    super(title, type, price, supplierId, author, isbn, numberOfPages)
  }
}
