import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatTableDataSource} from "@angular/material";
import {Article} from "../../domain/Article";
import {ArticleService} from "../../services/article.service";

@Component({
  selector: 'app-table-articles',
  styleUrls: ['./table-articles.component.css'],
  templateUrl: './table-articles.component.html',
})
export class TableArticlesComponent implements OnInit {
  displayedColumns: string[] = ['title', 'type', 'price', 'article_id', 'supplier_id'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  dataSource: MatTableDataSource<Article>;

  constructor(private service: ArticleService) {
  }


  ngOnInit() {
    this.service.allArticles().subscribe(data => {
      this.dataSource = new MatTableDataSource<Article>(data);
    });
  }
}
