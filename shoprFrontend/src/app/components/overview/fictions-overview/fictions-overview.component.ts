import { Component, OnInit } from '@angular/core';
import {FictionService} from "../../../services/fiction.service";
import {DataService} from "../../../services/data.service";

@Component({
  selector: 'app-fictions-overview',
  templateUrl: './fictions-overview.component.html',
  styleUrls: ['./fictions-overview.component.css']
})
export class FictionsOverviewComponent implements OnInit {


  constructor(private fictionService:FictionService,private dataService:DataService) { }

  fictions = []
  displayedColumns: string[] =['no', 'Title', 'price','author','totalPages','isbn','preview','details']


  ngOnInit() {

    this.fictionService.getFictions()
      .subscribe(data=>this.fictions=data)
  }


  passId(toPassId){
    this.dataService.changeId(toPassId)
  }

}
