import {Item} from "./item";

export class NonFiction extends Item{


  subject:string


  constructor(id?: number, title?: string, type?: string, price?: number, subject?: string) {
    super(id, title, type, price);
    this.subject = subject;
  }
}
