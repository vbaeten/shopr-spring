import {Item} from "./item";

export class Fiction extends Item{


  bookGenre:string
  preview:string
  author:string
  totalPages:number
  isbn:number


  constructor(id?: number, title?: string, type?: string, price?: number, bookGenre?: string, preview?: string,
              author?:string, totalPages?:number, isbn?:number) {
    super(id, title, type, price);
    this.bookGenre = bookGenre;
    this.preview = preview;
    this.author = author
    this.isbn = isbn
    this.totalPages = totalPages
  }
}
