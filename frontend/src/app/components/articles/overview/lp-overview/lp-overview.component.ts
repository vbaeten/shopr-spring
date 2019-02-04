import { Component, OnInit } from '@angular/core';
import {Lp} from "../../../../models/lp";

@Component({
  selector: 'app-lp-overview',
  templateUrl: './lp-overview.component.html',
  styleUrls: ['./lp-overview.component.css']
})
export class LpOverviewComponent implements OnInit {

  lps: Lp[] = [];

  constructor() { }

  ngOnInit() {
  }

}
