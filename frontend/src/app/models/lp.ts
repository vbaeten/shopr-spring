export class Lp {

  public id: number;
  public title: string;
  public artist: string;
  public genre: string;
  public supplier: string;
  public price: number;


  constructor(id: number, title: string, artist: string, genre: string, supplier: string, price: number) {
    this.id = id;
    this.title = title;
    this.artist = artist;
    this.genre = genre;
    this.supplier = supplier;
    this.price = price;
  }
}
