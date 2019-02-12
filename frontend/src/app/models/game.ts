import {GameGenre} from "./game-genre"
import {Article} from "./article";

export class Game extends Article {

  public publisher: string;
  public minimumAge: number;
  public gameGenre: GameGenre;


  constructor(publisher?: string, minimumAge?: number, gameGenre?: GameGenre) {
    super();
    this.publisher = publisher;
    this.minimumAge = minimumAge;
    this.gameGenre = gameGenre;
  }

}
