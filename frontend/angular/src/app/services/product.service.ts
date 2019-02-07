import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http'

import {Observable} from "rxjs";
import {Product} from "../models/products.model";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  getProducts() : Observable<Product[]> {
    return this.http.get<Product[]>("/api/products/all");
  }

  getProductById(id: number) : Observable<Product> {
    return this.http.get<Product>('/api/products/' + id);
  }

}
