import { Component, OnInit } from '@angular/core';
import {Fiction} from "../../models/fiction";
import {FictionService} from "../../services/fiction.service";
import {NgForm} from "@angular/forms";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material";
import {DataService} from "../../services/data.service";

@Component({
  selector: 'app-add-fiction',
  templateUrl: './add-fiction.component.html',
  styleUrls: ['./add-fiction.component.css']
})
export class AddFictionComponent implements OnInit {


  fiction:Fiction
  title:string
  price:number


  constructor( private fictionService:FictionService, private router:Router, private dataService:DataService) { }



  ngOnInit() {
  }



  addFiction(form:NgForm){

    this.fiction=new Fiction()
    this.fiction.title = this.title
    this.fiction.price = this.price
    this.fiction.bookGenre = form.value.genre
    this.fiction.preview = form.value.preview
    this.fiction.author = form.value.author
    this.fiction.totalPages = form.value.totalPages
    this.fiction.isbn = form.value.isbn
    this.fictionService.createFiction(this.fiction)
      .subscribe(data=>this.fiction=data)
    this.router.navigate(['/fictionsOverview'])
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
