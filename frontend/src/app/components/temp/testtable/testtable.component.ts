import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort } from '@angular/material';
import { TesttableDataSource } from './testtable-datasource';

@Component({
  selector: 'app-testtable',
  templateUrl: './testtable.component.html',
  styleUrls: ['./testtable.component.css']
})
export class TesttableComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  dataSource: TesttableDataSource;

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['id', 'name'];

  ngOnInit() {
    this.dataSource = new TesttableDataSource(this.paginator, this.sort);
  }
}
