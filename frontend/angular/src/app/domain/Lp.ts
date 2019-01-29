import {Article} from "./Article";

export class Lp extends Article{
  constructor(public title: string,
              public type: string,
              public price: number,
              public supplierId: string,
              public lpGenre:string,
              public artist:string,
              public articleId?: string,) {
    super(title, type, price, supplierId, articleId)
  }
}


