import {Item} from "./item";

export class Fiction extends Item{


  bookGenre:string
  preview:string


  constructor(id?: number, title?: string, type?: string, price?: number, bookGenre?: string, preview?: string) {
    super(id, title, type, price);
    this.bookGenre = bookGenre;
    this.preview = preview;
  }
}
