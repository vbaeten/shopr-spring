import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {Lp} from "../../../../../models/lp";
import {MatPaginator, MatSnackBar, MatSort, MatTableDataSource} from "@angular/material";
import {LpService} from "../../../../../services/lp.service";
import {Router} from "@angular/router";
import {ArticleService} from "../../../../../services/article.service";

@Component({
  selector: 'app-lp-overview',
  templateUrl: './lp-overview.component.html',
  styleUrls: ['./lp-overview.component.css']
})
export class LpOverviewComponent implements OnInit {
  @Input() type: string;
  selectedArticle: Lp;
  displayedColumns: string[] = ['articleId', 'title', 'price', 'supplierId', 'type', 'delete', 'details'];
  dataSource = new MatTableDataSource<Lp>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private notification: MatSnackBar, private lpService: LpService, private articleService: ArticleService, private router: Router) {
  }

  ngOnInit() {
    this.getAllLps();
  }

  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  getAllLps = () => {
    this.lpService.getLps()
      .subscribe(data => {
        this.dataSource.data = data as Lp[];
      })
  };

  deleteLp = (id: number) => {
    this.articleService.deleteArticle(id).subscribe(response => {
        this.getAllLps();
        this.notification.open("Article has been deleted", "👍", {duration: 3000});
      },
      error => {
        this.notification.open("Something went wrong", "article has not been deleted, try again! 👎", {duration: 3000});
      })
  };

  getLpById(id: number) {
    this.lpService.getLpById(id)
  }

  goToDetailsPage(lp: Lp) {
    this.router.navigate(["/article/lp-details/", lp.articleId]);
    sessionStorage.setItem('selectedArticle', JSON.stringify(lp))
  }


  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }


}
