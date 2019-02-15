export class Review{

  description:string
  score:number


  constructor(description?: string, score?: number) {
    this.description = description;
    this.score = score;
  }
}
