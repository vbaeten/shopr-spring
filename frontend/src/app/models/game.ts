export class Game {

  public id: number;
  public title: string;
  public genre: string;
  public publisher: string;
  public minAge: number;
  public supplier: string;
  public price: number;


  constructor(id?: number, title?: string, genre?: string, publisher?: string, minAge?: number, supplier?: string, price?: number) {
    this.id = id;
    this.title = title;
    this.genre = genre;
    this.publisher = publisher;
    this.minAge = minAge;
    this.supplier = supplier;
    this.price = price;
  }

}
