import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {LpService} from "../../services/lp.service";
import {Lp} from "../../models/lp";
import {Router} from "@angular/router";
import {DataService} from "../../services/data.service";

@Component({
  selector: 'app-add-lp',
  templateUrl: './add-lp.component.html',
  styleUrls: ['./add-lp.component.css']
})
export class AddLpComponent implements OnInit {


  lp: Lp
  title:string
  price:number


  constructor(private lpService:LpService, private router:Router,private dataService:DataService) { }

  ngOnInit() {
  }



  addLp(form:NgForm){

    this.lp = new Lp()
    this.lp.genre=form.value.genre
    this.lp.publisher=form.value.publisher
    this.lp.title = this.title
    this.lp.price = this.price
    this.lpService.createLp(this.lp)
      .subscribe(data=>this.lp=data)
    this.router.navigate(['/lpsOverview'])
  }


  setTitle(value: string) {
    this.title = value;
  }

  setPrice(value: number) {
    this.price = value;
  }

  showSnackBar(){
    let message= 'succesfully added your item'
    let action= ''
    this.dataService.openSnackBar(message,action)
  }
}
