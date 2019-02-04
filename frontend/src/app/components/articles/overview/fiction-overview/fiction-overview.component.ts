import {Component, OnInit} from '@angular/core';
import {Fiction} from '../../../../models/fiction';
import {FictionService} from '../../../../services/fiction.service';

@Component({
  selector: 'app-fiction-overview',
  templateUrl: './fiction-overview.component.html',
  styleUrls: ['./fiction-overview.component.css']
})
export class FictionOverviewComponent implements OnInit {

  fictionBooks: Fiction[] = [];
  dataSource;
  displayedColumns: string[] = ['id', 'title', 'price'];

  constructor(private fictionService: FictionService) {
  }

  ngOnInit() {
    this.fictionService.getFictionBooks().subscribe(data => {
      this.fictionBooks = data;
      this.dataSource = this.fictionBooks;
    });
  }
}
