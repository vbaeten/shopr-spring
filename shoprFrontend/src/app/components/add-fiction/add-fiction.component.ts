import { Component, OnInit } from '@angular/core';
import {Fiction} from "../../models/fiction";
import {FictionService} from "../../services/fiction.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-add-fiction',
  templateUrl: './add-fiction.component.html',
  styleUrls: ['./add-fiction.component.css']
})
export class AddFictionComponent implements OnInit {


  fiction:Fiction
  title:string
  price:number


  constructor( private fictionService:FictionService) { }



  ngOnInit() {
  }



  addFiction(form:NgForm){

    this.fiction=new Fiction()
    this.fiction.title = this.title
    this.fiction.price = this.price
    this.fiction.bookGenre = form.value.genre
    this.fiction.preview = form.value.preview
    this.fictionService.createFiction(this.fiction)
      .subscribe(data=>this.fiction=data)
  }



  setTitle(value: string) {
    this.title = value;
  }

  setPrice(value: number) {
    this.price = value;
  }

}
