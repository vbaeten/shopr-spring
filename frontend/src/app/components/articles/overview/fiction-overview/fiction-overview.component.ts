import { Component, OnInit } from '@angular/core';
import {Fiction} from '../../../../models/fiction';

@Component({
  selector: 'app-fiction-overview',
  templateUrl: './fiction-overview.component.html',
  styleUrls: ['./fiction-overview.component.css']
})
export class FictionOverviewComponent implements OnInit {

  fictionBooks: Fiction[] = [];

  constructor() { }

  ngOnInit() {
  }

}
