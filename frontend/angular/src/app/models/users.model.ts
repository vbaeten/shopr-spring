import {ShoppingCart} from "./shoppingCart.model";

export class User {
  public username: string;
  public firstname: string;
  public lastname: string;
  public password: string;
  public active: boolean;
  public role?: string;
  public id?: number;
  public cart: ShoppingCart;

  // public setUsersShoppingCart(cart: ShoppingCart) {
  //   cart.userId = this.id;
  //   cart.items = [];
  //   cart.
  // }

}
