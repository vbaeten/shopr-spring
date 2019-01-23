import {Component} from '@angular/core';

export interface PeriodicElement {
  title: string;
  type: string;
  price: number;
  article_id: number;
  supplier_id: string;
}

@Component({
  selector: 'app-table-articles',
  styleUrls: ['table-articles.css'],
  templateUrl: 'table-articles.html',
})
export class TableArticlesComponent {
  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource = ;
}
