import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {Fiction} from '../../../../models/fiction';
import {FictionService} from '../../../../services/fiction.service';

@Component({
  selector: 'app-add-fiction',
  templateUrl: './add-fiction.component.html',
  styleUrls: ['./add-fiction.component.css']
})
export class AddFictionComponent implements OnInit {

  fiction: Fiction;

  constructor(private fictionService: FictionService) { }

  ngOnInit() {
  }

  onSubmit(form: NgForm) {
    this.fiction = new Fiction();
    this.fiction.title = form.value.title;
    this.fiction.author = form.value.author;
    this.fiction.genre = form.value.genre;
    this.fiction.isbn = form.value.isbn;
    this.fiction.pages = form.value.pages;
    this.fiction.synopsis = form.value.synopsis;
    this.fiction.price = form.value.price;
    this.fiction.supplier = form.value.supplier;
    this.fiction.type = 'Fiction';
    this.fictionService.addFiction(this.fiction).subscribe(data => this.fiction = data);
  }

}
