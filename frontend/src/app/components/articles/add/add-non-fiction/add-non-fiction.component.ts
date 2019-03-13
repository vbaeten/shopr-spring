import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {NonFiction} from '../../../../models/non-fiction';
import {NonFictionService} from '../../../../services/non-fiction.service';

@Component({
  selector: 'app-add-non-fiction',
  templateUrl: './add-non-fiction.component.html',
  styleUrls: ['./add-non-fiction.component.css']
})
export class AddNonFictionComponent implements OnInit {

  nonFiction: NonFiction;
  addNonFictionForm: FormGroup;

  constructor(private nonFictionService: NonFictionService) { }

  ngOnInit() {
    this.addNonFictionForm = new FormGroup({
      title: new FormControl(''),
      author: new FormControl(''),
      subject: new FormControl(''),
      price: new FormControl(''),
      pages: new FormControl(''),
      supplier: new FormControl(''),
      isbn: new FormControl('')
    });
  }

  onSubmit() {
    this.nonFiction = new NonFiction();
    this.nonFiction.title = this.addNonFictionForm.value.title;
    this.nonFiction.author = this.addNonFictionForm.value.author;
    this.nonFiction.subject = this.addNonFictionForm.value.subject;
    this.nonFiction.price = this.addNonFictionForm.value.price;
    this.nonFiction.pages = this.addNonFictionForm.value.pages;
    this.nonFiction.supplier = this.addNonFictionForm.value.supplier;
    this.nonFiction.isbn = this.addNonFictionForm.value.isbn;
    this.nonFiction.type = 'Non-Fiction';
    this.nonFictionService.addNonFiction(this.nonFiction).subscribe(data => this.nonFiction  = data);
  }
}
