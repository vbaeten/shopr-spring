import {Injectable} from '@angular/core';
import {Product} from "../models/products.model";
import {ProductService} from "./product.service";
import {ShoppingCart} from "../models/shoppingCart.model";
import {CartItem} from "../models/cartItem.model";

const CART_KEY = "cart";

@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {

  products: Product[];

  constructor(private productService: ProductService) {
    this.productService.getProducts().subscribe((products) => this.products = products);
  }

  public addToCart(product: Product, quantity: number): void {
    const cart = this.retrive();

    let item = cart.items.find((p) => p.productId === product.id);
    if(item === undefined) {
      item = new CartItem();
      item.productId = product.id;
      cart.items.push(item);
      alert("Adding Product to Cart ");
    }

    item.quantity += quantity;

    this.save(cart);
    this.calculateCart(cart);
  }

  private retrive(): ShoppingCart {
    const cart = new ShoppingCart();
    const storedCart = localStorage.getItem(CART_KEY);
    if(storedCart) {
      cart.updateCart(JSON.parse(storedCart));
    }
    return cart;
  }

  private save(cart: ShoppingCart): void {
    localStorage.setItem(CART_KEY, JSON.stringify(cart));
  }

  private calculateCart(cart: ShoppingCart): void {
    cart.totalPrice = cart.items
      .map((item) => item.quantity * this.products.find((p) => p.id === item.productId).price)
      .reduce((previous, current) => previous + current, 0);
  }

  public empty(): void {
    const newCart = new ShoppingCart();
    this.save(newCart);
  }
}
