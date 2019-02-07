import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {Article} from "../../domain/Article";
import {ArticleService} from "../../services/article.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-table-articles',
  styleUrls: ['./table-articles.component.css'],
  templateUrl: './table-articles.component.html',
})
export class TableArticlesComponent implements OnInit {
  displayedColumns: string[] = ['title', 'type', 'price', 'articleId', 'supplierId', 'detail'];
  dataSource: MatTableDataSource<Article>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private service: ArticleService, public router: Router) {
  }

  ngOnInit() {
    this.service.allArticles().subscribe(data => {
      this.dataSource = new MatTableDataSource<Article>(data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  applyFilter(filterValue: String) {
    this.dataSource.filter = filterValue.trim().toLocaleLowerCase();
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  goToDetail(articleId: Number) {
    console.log("goto detail")
    this.router.navigate(['/articles/detail', articleId]);
  }
}
