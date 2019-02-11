export class Lp {

  public id: number;
  public title: string;
  public artist: string;
  public genre: string;
  public supplier: string;
  public price: number;
  public type: string;


  constructor(id?: number, title?: string, artist?: string, genre?: string, supplier?: string, price?: number, type?: string) {
    this.id = id;
    this.title = title;
    this.artist = artist;
    this.genre = genre;
    this.supplier = supplier;
    this.price = price;
    this.type = type;
  }
}
