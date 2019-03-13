import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Fiction} from '../../../../models/fiction';
import {FictionService} from '../../../../services/fiction.service';

@Component({
  selector: 'app-add-fiction',
  templateUrl: './add-fiction.component.html',
  styleUrls: ['./add-fiction.component.css']
})
export class AddFictionComponent implements OnInit {

  fiction: Fiction;
  addFictionForm: FormGroup;

  constructor(private fictionService: FictionService) { }

  ngOnInit() {
    this.addFictionForm = new FormGroup({
      title: new FormControl(''),
      author: new FormControl(''),
      genre: new FormControl(''),
      isbn: new FormControl(''),
      pages: new FormControl(''),
      synopsis: new FormControl(''),
      price: new FormControl(''),
      supplier: new FormControl('')
    });
  }

  onSubmit() {
    this.fiction = new Fiction();
    this.fiction.title = this.addFictionForm.value.title;
    this.fiction.author = this.addFictionForm.value.author;
    this.fiction.genre = this.addFictionForm.value.genre;
    this.fiction.isbn = this.addFictionForm.value.isbn;
    this.fiction.pages = this.addFictionForm.value.pages;
    this.fiction.synopsis = this.addFictionForm.value.synopsis;
    this.fiction.price = this.addFictionForm.value.price;
    this.fiction.supplier = this.addFictionForm.value.supplier;
    this.fiction.type = 'Fiction';
    this.fictionService.addFiction(this.fiction).subscribe(data => this.fiction = data);
  }

}
