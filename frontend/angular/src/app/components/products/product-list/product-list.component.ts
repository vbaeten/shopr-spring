import {Component, OnInit, ViewChild} from '@angular/core';

import {ProductService} from "../../../services/product.service";
import {Product} from "../../../models/products.model";
import {MatPaginator, MatTableDataSource} from "@angular/material";
import {FormControl} from "@angular/forms";
import {Observable} from "rxjs";
import {map, startWith} from "rxjs/operators";
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
  filteredOptions: Observable<string[]>;

  searchField = new FormControl();

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private productService: ProductService, private shoppingService: ShoppingCartService) { }

  ngOnInit() {

    this.productService.getProducts().subscribe((products) => {
      this.products = products;
      this.options = this.products.map((p) => p.title);
      console.log("Options: " + this.options);

    });

    this.filteredOptions = this.searchField.valueChanges
      .pipe(
        startWith(''),
        map(value => this._filter(value))
      );

    this.productService.getProducts().subscribe(data => {
      this.products = data;
      this.dataSource = new MatTableDataSource<Product>(data);
      this.dataSource.paginator = this.paginator;
    });
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.options.filter(option => option.toLowerCase().includes(filterValue));
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  addToCart(product: Product, quantity: number): void {
    this.shoppingService.addToCart(product, quantity);
  }
}
