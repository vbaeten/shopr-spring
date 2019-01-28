import {Item} from "./item";

export class NonFiction extends Item{


  subject:string
  author:string
  totalPages:number
  isbn:number


  constructor(id?: number, title?: string, type?: string, price?: number, subject?: string,
              author?:string, totalPages?:number,isbn?:number) {
    super(id, title, type, price);
    this.subject = subject;
    this.author = author
    this.isbn = isbn
    this.totalPages = totalPages
  }
}
