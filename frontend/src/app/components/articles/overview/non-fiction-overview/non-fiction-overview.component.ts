import {Component, OnInit} from '@angular/core';
import {NonFiction} from '../../../../models/non-fiction';
import {NonFictionService} from '../../../../services/non-fiction.service';

@Component({
  selector: 'app-non-fiction-overview',
  templateUrl: './non-fiction-overview.component.html',
  styleUrls: ['./non-fiction-overview.component.css']
})
export class NonFictionOverviewComponent implements OnInit {

  nonFictionBooks: NonFiction[] = [];
  dataSource;
  displayedColumns: string[] = ['id', 'title', 'price'];


  constructor(private nonFictionService: NonFictionService) {
  }

  ngOnInit() {
    this.nonFictionService.getNonFictionBooks().subscribe(data => {
      this.nonFictionBooks = data;
      this.dataSource = this.nonFictionBooks;
    });
  }

}
