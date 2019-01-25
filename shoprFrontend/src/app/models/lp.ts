import {Item} from "./item";

export class Lp extends Item{


  publisher:string
  genre:string


  constructor(id?: number, title?: string, type?: string, price?: number, publisher?: string, genre?: string) {
    super(id, title, type, price);
    this.publisher = publisher;
    this.genre = genre;
  }
}
