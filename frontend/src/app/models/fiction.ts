export class Fiction {

  public id: number;
  public title: string;
  public author: string;
  public isbn: number;
  public pages: number;
  public genre: string;
  public synopsis: string;
  public supplier: string;
  public price: number;
  public type: string;


  constructor(id?: number, title?: string, author?: string, isbn?: number, pages?: number, genre?: string,
              synopsis?: string, supplier?: string, price?: number, type?: string) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.pages = pages;
    this.genre = genre;
    this.synopsis = synopsis;
    this.supplier = supplier;
    this.price = price;
    this.type = type;
  }
}
