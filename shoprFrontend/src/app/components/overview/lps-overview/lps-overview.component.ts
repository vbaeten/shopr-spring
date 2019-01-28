import { Component, OnInit } from '@angular/core';
import {LpService} from "../../../services/lp.service";

@Component({
  selector: 'app-lps-overview',
  templateUrl: './lps-overview.component.html',
  styleUrls: ['./lps-overview.component.css']
})
export class LpsOverviewComponent implements OnInit {


  lps = []
  displayedColumns: string[] =['no', 'Title', 'price','publisher']


  constructor(private lpService:LpService) { }

  ngOnInit() {

    this.lpService.getLps()
      .subscribe(data=>this.lps=data)
  }


}
