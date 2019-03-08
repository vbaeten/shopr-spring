import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSnackBar, MatSort, MatTableDataSource} from "@angular/material";
import {Router} from "@angular/router";
import {Fiction} from "../../../../../models/fiction";
import {FictionService} from "../../../../../services/fiction.service";
import {ArticleService} from "../../../../../services/article.service";

@Component({
  selector: 'app-fiction-overview',
  templateUrl: './fiction-overview.component.html',
  styleUrls: ['./fiction-overview.component.css']
})
export class FictionOverviewComponent implements OnInit {
  @Input() type: string;
  selectedArticle: Fiction;
  displayedColumns: string[] = ['articleId', 'title', 'price', 'supplierId', 'type', 'delete', 'details'];
  dataSource = new MatTableDataSource<Fiction>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private notification: MatSnackBar, private fictionService: FictionService,private articleService: ArticleService, private router: Router) {
  }

  ngOnInit() {
    this.getAllFictions();
  }

  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  getAllFictions = () => {
    this.fictionService.getFictions()
      .subscribe(data => {
        this.dataSource.data = data as Fiction[];
      })
  };

  deleteFiction = (id: number) => {
    this.articleService.deleteArticle(id).subscribe(response => {
        this.getAllFictions();
        this.notification.open("Article has been deleted", "👍", {duration: 3000});
      },
      error => {
        this.notification.open("Something went wrong", "article has not been deleted, try again! 👎", {duration: 3000});
      })
  };

  getFictionById(id: number) {
    this.fictionService.getFictionById(id)
  }

  goToDetailsPage(fiction: Fiction) {
    this.router.navigate(["/article/fiction-details/", fiction.articleId]);
    sessionStorage.setItem('selectedArticle', JSON.stringify(fiction))
  }


  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }


}
