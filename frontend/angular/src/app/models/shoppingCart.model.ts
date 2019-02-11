import {CartItem} from "./cartItem.model";

export class ShoppingCart {

  public items: CartItem[] = [];
  public totalItems: number = 0;
  public totalPrice: number = 0;

  public updateCart(cart: ShoppingCart) {
    this.items = cart.items;
    this.totalItems = cart.totalItems;
    this.totalPrice =  cart.totalPrice;
  }
}
