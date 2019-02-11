import {Article} from "./article";

export class Game extends Article{
  constructor(public title: string,
              public type: string,
              public price: number,
              public supplierId: string,
              public gameGenre:string,
              public minimumAge:number,
              public publisher:string,
              public articleId?: string,) {
    super(title, type, price, supplierId, articleId)
  }
}
