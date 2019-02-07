import {Component, OnInit, ViewChild} from '@angular/core';

import {ProductService} from "../../../services/product.service";
import {Product} from "../../../models/products.model";
import {MatPaginator, MatTableDataSource} from "@angular/material";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[];
  dataSource;
  displayedColumns: string[] = ['id', 'title', 'price', 'type', 'genre', 'action'];

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {

    this.productService.getProducts().subscribe(data => {
      this.products = data;
      this.dataSource = new MatTableDataSource<Product>(data);
      this.dataSource.paginator = this.paginator;
    });
  }

}
