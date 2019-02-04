import { Component, OnInit } from '@angular/core';
import {NonFiction} from '../../../../models/non-fiction';

@Component({
  selector: 'app-non-fiction-overview',
  templateUrl: './non-fiction-overview.component.html',
  styleUrls: ['./non-fiction-overview.component.css']
})
export class NonFictionOverviewComponent implements OnInit {

  nonFictionBooks: NonFiction[] = [];

  constructor() { }

  ngOnInit() {
  }

}
