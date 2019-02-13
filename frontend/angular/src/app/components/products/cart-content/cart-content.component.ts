import {Component, OnDestroy, OnInit} from '@angular/core';
import {ProductService} from "../../../services/product.service";
import {ShoppingCartService} from "../../../services/shopping-cart.service";
import {Product} from "../../../models/products.model";
import {Observable, Subscription} from "rxjs";
import {ShoppingCart} from "../../../models/shoppingCart.model";

@Component({
  selector: 'app-cart-content',
  templateUrl: './cart-content.component.html',
  styleUrls: ['./cart-content.component.css']
})
export class CartContentComponent implements OnInit, OnDestroy {

  products: Observable<Product[]>;
  cart: Observable<ShoppingCart>;
  itemCount: number;

  private cartSubscription: Subscription;

  constructor(private productService: ProductService, private shoppingCartService: ShoppingCartService) {
  }

  ngOnInit() {
    this.products = this.productService.getProducts();
    this.cart = this.shoppingCartService.get();
    this.cartSubscription = this.cart.subscribe((cart) => {
      this.itemCount = cart.items.map(product => product.quantity).reduce((previous, current) => previous + current, 0);
    });
  }

  public emptyCart(): void {
    this.shoppingCartService.empty();
  }

  ngOnDestroy(): void {
    if(this.cartSubscription) {
      this.cartSubscription.unsubscribe();
    }
  }

}
