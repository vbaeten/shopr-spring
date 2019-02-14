export class Order{

  id:number
  totalPrice:number


  constructor(id?: number, totalPrice?: number) {
    this.id = id;
    // this.date = date;
    this.totalPrice = totalPrice;
  }
}
