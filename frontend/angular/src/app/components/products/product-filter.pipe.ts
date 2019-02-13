import {Pipe, PipeTransform} from '@angular/core';
import {Product} from "../../models/products.model";

@Pipe({
  name: 'productFilter'
})
export class ProductFilterPipe implements PipeTransform {

  transform(products: Product[], text: string): Product[] {
    if(text == null || text === "") {
      return products;
    }
    return products.filter(
      p => p.title.toLowerCase().includes(text) ||
        p.type.includes(text) ||
        p.genre.toLowerCase().includes(text));
  }

}
