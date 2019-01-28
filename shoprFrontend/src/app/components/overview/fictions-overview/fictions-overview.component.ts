import { Component, OnInit } from '@angular/core';
import {FictionService} from "../../../services/fiction.service";

@Component({
  selector: 'app-fictions-overview',
  templateUrl: './fictions-overview.component.html',
  styleUrls: ['./fictions-overview.component.css']
})
export class FictionsOverviewComponent implements OnInit {


  constructor(private fictionService:FictionService) { }

  fictions = []
  displayedColumns: string[] =['no', 'Title', 'price','author','totalPages','isbn','preview']


  ngOnInit() {

    this.fictionService.getFictions()
      .subscribe(data=>this.fictions=data)
  }

}
