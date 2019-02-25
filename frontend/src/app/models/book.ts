import {Article} from "./article";

export abstract class Book extends Article {

  public author: string;
  public isbn: string;
  public nrOfPages: number;
  public bookType: string;

  constructor(author?: string, isbn?: string, nrOfPages?: number, bookType?: string) {
    super();
    this.author = author;
    this.isbn = isbn;
    this.nrOfPages = nrOfPages;
    this.bookType = bookType;
  }
}
