import { Component, OnInit } from '@angular/core';
import {DataService} from "../../../services/data.service";
import {FictionService} from "../../../services/fiction.service";

@Component({
  selector: 'app-fictions-detail',
  templateUrl: './fictions-detail.component.html',
  styleUrls: ['./fictions-detail.component.css']
})
export class FictionsDetailComponent implements OnInit {

  passedId:number
  fiction

  constructor(private dataService:DataService,private fictionService:FictionService) { }


  ngOnInit() {
    this.dataService.detailId.subscribe(id=>this.passedId=id)
    this.fiction= this.fictionService.getById(this.passedId).subscribe(fiction=>this.fiction=fiction)
  }

  delete(){
    console.log(this.passedId)
    this.fictionService.deleteById(this.passedId).subscribe(fiction=>this.fiction=fiction)
  }

}
