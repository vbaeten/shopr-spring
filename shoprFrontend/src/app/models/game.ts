import {Item} from "./item";

export class Game extends Item{

  publisher:string
  minAge:number
  gameGenre:string


  constructor( id?:number, title?: string, type?: string, price?: number, publisher?: string, minAge?: number) {
    super(id, title, type, price);
    this.publisher = publisher;
    this.minAge = minAge;

  }
}
