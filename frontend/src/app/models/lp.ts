import {Article} from "./article";
import {LpGenre} from "./lp-genre";

export class Lp extends Article {
  public publisher: string;
  public lpGenre: LpGenre;


  constructor(publisher?: string, lpGenre?: LpGenre) {
    super();
    this.publisher = publisher;
    this.lpGenre = lpGenre;
  }
}
