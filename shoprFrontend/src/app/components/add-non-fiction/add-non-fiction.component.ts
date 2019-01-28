import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {NonFictionService} from "../../services/non-fiction.service";
import {NonFiction} from "../../models/nonFiction";

@Component({
  selector: 'app-add-non-fiction',
  templateUrl: './add-non-fiction.component.html',
  styleUrls: ['./add-non-fiction.component.css']
})
export class AddNonFictionComponent implements OnInit {


  nonFiction:NonFiction
  title:string
  price:number


  constructor(private nonFictionService:NonFictionService) { }

  ngOnInit() {
  }




  addNonFiction(form:NgForm){

    this.nonFiction = new NonFiction()
    this.nonFiction.title=this.title
    this.nonFiction.price=this.price
    this.nonFiction.subject=form.value.subject
    this.nonFiction.subject=form.value.publisher
    this.nonFiction.author = form.value.author
    this.nonFiction.totalPages = form.value.totalPages
    this.nonFiction.isbn = form.value.isbn
    this.nonFictionService.createNonFiction(this.nonFiction)
      .subscribe(data=>this.nonFiction=data)

  }


  setTitle(value: string) {
    this.title = value;
  }

  setPrice(value: number) {
    this.price = value;
  }

}
