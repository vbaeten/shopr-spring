import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {NonFiction} from "../../../../../models/nonFiction";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {NonFictionService} from "../../../../../services/non-fiction.service";
import {Router} from "@angular/router";
import {ArticleService} from "../../../../../services/article.service";

@Component({
  selector: 'app-non-fiction-overview',
  templateUrl: './non-fiction-overview.component.html',
  styleUrls: ['./non-fiction-overview.component.css']
})
export class NonFictionOverviewComponent implements OnInit {
  @Input() type: string;
  selectedArticle: NonFiction;
  displayedColumns: string[] = ['articleId', 'title', 'price', 'supplierId', 'type', 'delete', 'details'];
  dataSource = new MatTableDataSource<NonFiction>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private nonFictionService: NonFictionService, private articleService: ArticleService, private router: Router) {
  }

  ngOnInit() {
    this.getAllNonFictions();
  }

  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  getAllNonFictions = () => {
    this.nonFictionService.getNonFictions()
      .subscribe(data => {
        this.dataSource.data = data as NonFiction[];
      })
  };

  deleteNonFiction = (id: number) => {
    this.articleService.deleteArticle(id).subscribe(() => {
      this.getAllNonFictions();
    });
  };

  getNonFictionById(id: number) {
    this.nonFictionService.getNonFictionById(id)
  }

  goToDetailsPage(nonFiction: NonFiction) {
    this.router.navigate(["/article/nonFiction-details/", nonFiction.articleId]);
    sessionStorage.setItem('selectedArticle', JSON.stringify(nonFiction))
  }


  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }


}
