import {Item} from "./item";

export class Orderline {


   id:number
   item:Item
   subTotal:number
   quantity:number


  constructor(id?: number, item?: Item, subTotal?: number, quantity?: number) {
    this.id = id;
    this.item = item;
    this.subTotal = subTotal;
    this.quantity = quantity;
  }
}
