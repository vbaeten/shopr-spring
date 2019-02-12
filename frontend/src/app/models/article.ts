
export class Article {

  public type: string;
  public title: string;
  public price: number;
  public supplierId: string;

  constructor(type?: string, title?: string, price?: number, supplierId?: string) {
    this.type = type;
    this.title = title;
    this.price = price;
    this.supplierId = supplierId;

  }
}
