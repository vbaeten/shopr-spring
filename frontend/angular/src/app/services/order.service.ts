import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UserService} from "./user.service";
import {ProductService} from "./product.service";
import {ShoppingCartService} from "./shopping-cart.service";
import {ShoppingCart} from "../models/shoppingCart.model";
import {Router} from "@angular/router";
import {Product} from "../models/products.model";
import {Observable} from "rxjs";
import {User} from "../models/users.model";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  cart: ShoppingCart;
  user: Observable<User>;
  products: Observable<Product[]>;

  constructor(
    private http: HttpClient,
    private userService: UserService,
    private productService: ProductService,
    private shoppingCartService: ShoppingCartService,
    private router: Router
  ) {
  }

  processOrder(): void {

    this.userService.getCurrentUser().subscribe(response => {
      if (response === null || response === undefined) {
        alert("You have to login first");
        this.router.navigate(['login']);
      } else {
        this.shoppingCartService.get().subscribe((cart) => {
          this.cart = cart;
          if (cart !== null) {
            this.http.post(`/api/cart`, this.cart).subscribe();
          }
          // this.http.post(`/api/cart/add`, this.cart.items).subscribe();
        });
      }
    });
  }
}
