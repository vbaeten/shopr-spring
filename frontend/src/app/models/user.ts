export class User {

  public id: number;
  public name: string;
  public firstName: string;
  public cartId: number;

  constructor( id?: number,  name?: string, firstName?: string, cartId?: number) {
    this.id = id;
    this.name = name;
    this.firstName = firstName;
    this.cartId = cartId;
  }
}
