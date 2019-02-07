export class NonFiction {

  public id: number;
  public title: string;
  public author: string;
  public isbn: number;
  public pages: number;
  public subject: string;
  public supplier: string;
  public price: number;


  constructor(id?: number, title?: string, author?: string, isbn?: number, pages?: number, subject?: string,
              supplier?: string, price?: number) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.pages = pages;
    this.subject = subject;
    this.supplier = supplier;
    this.price = price;
  }
}

