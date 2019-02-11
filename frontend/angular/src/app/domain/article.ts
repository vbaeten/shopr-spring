export class Article {
  constructor(public title: string,
              public type: string,
              public price: number,
              public supplierId: string,
              public articleId?: string) {
  }
}
