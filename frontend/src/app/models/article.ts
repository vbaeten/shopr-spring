export class Article {

  public id: number;
  public title: string;
  public supplier: string;
  public price: number;
  public type: string;


  constructor(id?: number, title?: string, supplier?: string, price?: number, type?: string) {
    this.id = id;
    this.title = title;
    this.supplier = supplier;
    this.price = price;
    this.type = type;
  }
}
