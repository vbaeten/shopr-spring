import {Component, OnInit} from '@angular/core';
import {Product} from "../../../models/products.model";
import {ProductService} from "../../../services/product.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  product: Product;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService
  ) {
    this.product = new Product();
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      const id = params['id'];
      this.getProductDetails(id);
    })
  }

  getProductDetails(id: number) {
    this.productService.getProductById(id).subscribe(data => this.product = data);
  }

  // addToCart(product: Product): void {
  //   this.productService.addToCart(product);
  // }
}
