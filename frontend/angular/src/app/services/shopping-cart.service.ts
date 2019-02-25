import {Injectable} from '@angular/core';
import {Product} from "../models/products.model";
import {ProductService} from "./product.service";
import {ShoppingCart} from "../models/shoppingCart.model";
import {CartItem} from "../models/cartItem.model";
import {BehaviorSubject, Observable} from "rxjs";
import {UserService} from "./user.service";

const CART_KEY = "cart";

@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {

  products: Product[];

  private _shoppingCartSubject: BehaviorSubject<ShoppingCart> = new BehaviorSubject(this.retrieve());
  private shoppingCartObs: Observable<ShoppingCart> = this._shoppingCartSubject.asObservable();
  // private subscribers: Observer[ShoppingCart] = [];

  constructor(private productService: ProductService, private userService: UserService) {

    this.productService.getProducts().subscribe((products) => this.products = products);

    // this._shoppingCartSubject = new Observable<ShoppingCart>((observer: Observer<ShoppingCart>) => {
    //   this.subscribers.push(observer);
    //   observer.next(this.retrieve());
    //   return () => {
    //     this.subscribers = this.subscribers.filter((obs) => obs !== observer);
    //   };
    // });
  }

  public get(): Observable<ShoppingCart> {
    return this.shoppingCartObs;
  }

  public addToCart(product: Product, quantity: number): void {
    const cart = this.retrieve();
    cart.userId = this.userService.getById();

    let item = cart.items.find((p) => p.productId === product.id);
    if(item === undefined) {
      item = new CartItem();
      item.productId = product.id;
      item.name = product.title;
      cart.items.push(item);
      alert("Adding Product to Cart ");
    }

    item.quantity += quantity;
    cart.totalItems += item.quantity;

    console.log("ProdId " + JSON.stringify(cart.items.map(p => p.productId)));

    this.calculateCart(cart);
    this.save(cart);
    this._shoppingCartSubject.next(cart);
  }

  private retrieve(): ShoppingCart {
    const cart = new ShoppingCart();
    const storedCart = localStorage.getItem("cart");
    if(storedCart) {
      cart.updateCart(JSON.parse(storedCart));
    }
    return cart;
  }

  private save(cart: ShoppingCart): void {
    cart.setId();
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
    this._shoppingCartSubject.next(newCart);
  }
}
