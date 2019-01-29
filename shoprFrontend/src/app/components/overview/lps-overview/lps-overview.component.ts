import { Component, OnInit } from '@angular/core';
import {LpService} from "../../../services/lp.service";
import {DataService} from "../../../services/data.service";

@Component({
  selector: 'app-lps-overview',
  templateUrl: './lps-overview.component.html',
  styleUrls: ['./lps-overview.component.css']
})
export class LpsOverviewComponent implements OnInit {


  lps = []
  displayedColumns: string[] =['no', 'Title', 'price','publisher','details']


  constructor(private lpService:LpService,private dataService:DataService) { }

  ngOnInit() {

    this.lpService.getLps()
      .subscribe(data=>this.lps=data)
  }


  passId(toPassId){
    this.dataService.changeId(toPassId)
  }
}
