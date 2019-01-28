
export class Item  {



  id:number
  title:string
  type: string
  price:number


  constructor(id?: number, title?: string, type?: string, price?: number) {
    this.id = id;
    this.title = title;
    this.type = type;
    this.price = price;
  }
}
