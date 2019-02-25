import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {Router} from "@angular/router";
import {Fiction} from "../../../../../models/fiction";
import {FictionService} from "../../../../../services/fiction.service";

@Component({
  selector: 'app-fiction-overview',
  templateUrl: './fiction-overview.component.html',
  styleUrls: ['./fiction-overview.component.css']
})
export class FictionOverviewComponent implements OnInit {

  selectedArticle: Fiction;
  displayedColumns: string[] = ['articleId', 'title', 'price', 'supplierId', 'type', 'delete'];
  dataSource = new MatTableDataSource<Fiction>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private fictionService: FictionService, private router: Router) {
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
    this.fictionService.deleteFiction(id).subscribe(() => {
      this.getAllFictions();
    });
  };

  getFictionById(id: number) {
    this.fictionService.getFictionById(id)
  }

  goToDetailsPage(fiction: Fiction) {
    this.router.navigate(["/fiction/", fiction.articleId]);
    sessionStorage.setItem('selectedArticle', JSON.stringify(fiction))
  }


  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }


}
