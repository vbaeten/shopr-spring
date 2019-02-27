import {CartItem} from "./cartItem.model";

export class ShoppingCart {

  public id?: string;
  public userId?: number;
  public items: CartItem[] = [];
  public totalItems: number = 0;
  public totalPrice: number = 0;

  public updateCart(cart: ShoppingCart) {
    this.userId = cart.userId;
    this.items = cart.items;
    this.totalItems = cart.totalItems;
    this.totalPrice =  cart.totalPrice;
  }

  // public setId() {
  //   this.id = UUID.UUID();
  // }
}
