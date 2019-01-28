import { Component, OnInit } from '@angular/core';
import {NonFictionService} from "../../../services/non-fiction.service";

@Component({
  selector: 'app-non-fictions-overview',
  templateUrl: './non-fictions-overview.component.html',
  styleUrls: ['./non-fictions-overview.component.css']
})
export class NonFictionsOverviewComponent implements OnInit {


  nonFictions=[]
  displayedColumns: string[] =['no', 'Title', 'price','author','totalPages','isbn']


  constructor(private nonFictionService:NonFictionService) { }

  ngOnInit() {

    this.nonFictionService.getNonFictions()
      .subscribe(data=>this.nonFictions=data)
  }

}
