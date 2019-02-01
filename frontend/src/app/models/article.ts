
export class Article {

  constructor(
    public articleId: number,
    public title: String,
    public price: number,
    public supplierId: String,
    public type: String)
  {
    this.articleId = articleId;
    this.title = title;
    this.price = price;
    this.supplierId = supplierId;
    this.type = type;
  }

}
