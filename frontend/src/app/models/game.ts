import {GameGenre} from "./game-genre"

export class Game {

  constructor(
    public publisher: String,
    public minimumAge: number,
    public gameGenre: GameGenre)
  {
    this.publisher = publisher;
    this.minimumAge = minimumAge;
    this.gameGenre = gameGenre;
  }

}
