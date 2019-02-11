import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../../services/product.service";
import {ShoppingCartService} from "../../../services/shopping-cart.service";
import {Product} from "../../../models/products.model";
import {Observable} from "rxjs";

@Component({
  selector: 'app-cart-content',
  templateUrl: './cart-content.component.html',
  styleUrls: ['./cart-content.component.css']
})
export class CartContentComponent implements OnInit {

  products: Observable<Product[]>;
  itemCount: number;

  constructor(private productService: ProductService, private shoppingCartService: ShoppingCartService) { }

  ngOnInit() {
    this.products = this.productService.getProducts();
  }

  public emptyCart(): void {
    this.shoppingCartService.empty();
  }

}
