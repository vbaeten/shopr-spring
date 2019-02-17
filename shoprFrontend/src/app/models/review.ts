import {User} from "./user";
import {Item} from "./item";

export class Review{

  description:string
  score:number
  itemId:number
  item:Item




  constructor(description?: string, score?: number,itemId?:number,item?:Item) {
    this.description = description;
    this.score = score;
    this.itemId=itemId
    this.item=item
  }
}
