import {FictionGenre} from "./fiction-genre"
import {Book} from "./book";

export class Fiction extends Book {

  public shortSummary: string;
  public fictionGenre: FictionGenre;


  constructor(shortSummary?: string, fictionGenre?: FictionGenre) {
    super();
    this.shortSummary = shortSummary;
    this.fictionGenre = fictionGenre;
  }

}
