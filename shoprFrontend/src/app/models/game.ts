import {Item} from "./item";

export class Game extends Item{

  publisher:string
  minAge:number
  genre:string


  constructor(id?:number, title?: string, type?: string, price?: number, publisher?: string, minAge?: number, genre?: string) {
    super(id, title, type, price);
    this.publisher = publisher;
    this.minAge = minAge;
    this.genre = genre;
  }
}
