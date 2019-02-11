import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {NonFiction} from '../../../../models/non-fiction';
import {NonFictionService} from '../../../../services/non-fiction.service';

@Component({
  selector: 'app-add-non-fiction',
  templateUrl: './add-non-fiction.component.html',
  styleUrls: ['./add-non-fiction.component.css']
})
export class AddNonFictionComponent implements OnInit {

  nonFiction: NonFiction;

  constructor(private nonFictionService: NonFictionService) { }

  ngOnInit() {
  }

  onSubmit(form: NgForm) {
    this.nonFiction = new NonFiction();
    this.nonFiction.title = form.value.title;
    this.nonFiction.author = form.value.author;
    this.nonFiction.subject = form.value.subject;
    this.nonFiction.price = form.value.price;
    this.nonFiction.pages = form.value.pages;
    this.nonFiction.supplier = form.value.supplier;
    this.nonFiction.isbn = form.value.isbn;
    this.nonFiction.type = 'Non-Fiction';
    this.nonFictionService.addNonFiction(this.nonFiction).subscribe(data => this.nonFiction  = data);
  }
}
