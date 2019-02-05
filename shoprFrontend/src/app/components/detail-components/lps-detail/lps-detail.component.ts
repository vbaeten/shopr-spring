import { Component, OnInit } from '@angular/core';
import {DataService} from "../../../services/data.service";
import {LpService} from "../../../services/lp.service";

@Component({
  selector: 'app-lps-detail',
  templateUrl: './lps-detail.component.html',
  styleUrls: ['./lps-detail.component.css']
})
export class LpsDetailComponent implements OnInit {

  passedId:number
  lp

  constructor(private dataService:DataService,private lpService:LpService) { }


  ngOnInit() {
    this.dataService.detailId.subscribe(id=>this.passedId=id)
    this.lp= this.lpService.getById(this.passedId).subscribe(lp=>this.lp=lp)
  }

  delete(){
    console.log(this.passedId)
    this.lpService.deleteById(this.passedId).subscribe(lp=>this.lp=lp)
  }

}
