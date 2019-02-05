import { Component, OnInit } from '@angular/core';
import {DataService} from "../../../services/data.service";
import {NonFictionService} from "../../../services/non-fiction.service";

@Component({
  selector: 'app-non-fictions-detail',
  templateUrl: './non-fictions-detail.component.html',
  styleUrls: ['./non-fictions-detail.component.css']
})
export class NonFictionsDetailComponent implements OnInit {

  passedId:number
  nonFiction

  constructor(private dataService:DataService,private nonFictionService:NonFictionService) { }


  ngOnInit() {
    this.dataService.detailId.subscribe(id=>this.passedId=id)
    this.nonFiction= this.nonFictionService.getById(this.passedId).subscribe(nonFiction=>this.nonFiction=nonFiction)
  }

  delete(){
    console.log(this.passedId)
    this.nonFictionService.deleteById(this.passedId).subscribe(nonFiction=>this.nonFiction=nonFiction)
  }

}
