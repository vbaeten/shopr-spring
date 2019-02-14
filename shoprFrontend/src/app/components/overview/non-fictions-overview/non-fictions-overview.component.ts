import { Component, OnInit } from '@angular/core';
import {NonFictionService} from "../../../services/non-fiction.service";
import {LpService} from "../../../services/lp.service";
import {DataService} from "../../../services/data.service";

@Component({
  selector: 'app-non-fictions-overview',
  templateUrl: './non-fictions-overview.component.html',
  styleUrls: ['./non-fictions-overview.component.css']
})
export class NonFictionsOverviewComponent implements OnInit {


  nonFictions=[]
  displayedColumns: string[] =['no', 'Title','author','totalPages','isbn','details', 'price']


  constructor(private nonFictionService:NonFictionService,private dataService:DataService) { }

  ngOnInit() {

    this.nonFictionService.getNonFictions()
      .subscribe(data=>this.nonFictions=data)
  }


  passId(toPassId){
    this.dataService.changeId(toPassId)
  }

}
