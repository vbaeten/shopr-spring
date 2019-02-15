import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {Article} from "../../domain/article";
import {ArticleService} from "../../services/article.service";
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";
import {User} from "../../domain/user";

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
  currentUser: User;

  constructor(private articleService: ArticleService, public router: Router, private userService: UserService) {
  }

  ngOnInit() {
    this.userService.getCurrentUser().then(user => this.currentUser = user);
    this.articleService.allArticles().subscribe(data => {
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
