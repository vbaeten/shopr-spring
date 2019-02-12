import {Component, OnInit} from '@angular/core';

import {ProductService} from "../../../services/product.service";
import {Product} from "../../../models/products.model";
import {MatTableDataSource} from "@angular/material";
import {FormControl} from "@angular/forms";
import {ShoppingCartService} from "../../../services/shopping-cart.service";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[];
  dataSource;

  options: string[] = [];

  searchText: string;
  searchField = new FormControl();

  constructor(private productService: ProductService, private shoppingService: ShoppingCartService) { }

  ngOnInit() {

    this.productService.getProducts().subscribe((products) => {
      this.products = products;
      this.options = this.products.map((p) => p.title);
    });


    this.productService.getProducts().subscribe(data => {
      this.products = data;
      this.dataSource = new MatTableDataSource<Product>(data);
    });
  }

  addToCart(product: Product, quantity: number): void {
    this.shoppingService.addToCart(product, quantity);
  }
}
