import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.css']
})
export class OverviewComponent implements OnInit {
  selectedValue: string = "all";
  articleTypes: string[] = ["all","game", "lp", "fiction", "nonFiction"];

  constructor() { }

  ngOnInit() {
  }

}
