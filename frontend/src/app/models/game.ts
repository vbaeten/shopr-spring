export class Game {

  public id: number;
  public title: string;
  public genre: string;
  public publisher: string;
  public minAge: number;
  public supplier: string;
  public price: number;
  public type: string;


  constructor(id?: number, title?: string, genre?: string, publisher?: string, minAge?: number, supplier?: string, price?: number, type?: string) {
    this.id = id;
    this.title = title;
    this.genre = genre;
    this.publisher = publisher;
    this.minAge = minAge;
    this.supplier = supplier;
    this.price = price;
    this.type = type;
  }

}
