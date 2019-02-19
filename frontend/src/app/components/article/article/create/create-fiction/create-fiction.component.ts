import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Fiction} from "../../../../../models/fiction";
import {FictionGenre} from "../../../../../models/fiction-genre";
import {FictionService} from "../../../../../services/fiction.service";

@Component({
  selector: 'app-create-fiction',
  templateUrl: './create-fiction.component.html',
  styleUrls: ['./create-fiction.component.css']
})
export class CreateFictionComponent implements OnInit {
  @Input() type: string;
  fiction: Fiction;
  createFictionForm: FormGroup = this.formBuilder.group(
    {
      type: ['', Validators.required],
      title: ['', Validators.required],
      price: ['', Validators.required],
      supplierId: ['', Validators.required],
      author: ['', Validators.required],
      isbn: ['', Validators.required],
      nrOfPages: ['', Validators.required],
      bookType: ['', Validators.required],
      shortSummary: ['', Validators.required],
      fictionGenre: ['', Validators.required],
    });


  fictionGenres(): Array<string> {
    return Object.keys(FictionGenre).filter(
      (type) => isNaN(<any>type) && type !== 'values'
    );
  }

  constructor(private fictionService: FictionService,
              private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.createFictionForm.patchValue({type: this.type});
    this.createFictionForm.patchValue({bookType: this.type})
  }


  createFiction = () => {
    this.fiction = new Fiction();
    this.fiction.type = this.createFictionForm.value.type;
    this.fiction.title = this.createFictionForm.value.title;
    this.fiction.price = this.createFictionForm.value.price;
    this.fiction.supplierId = this.createFictionForm.value.supplierId;
    this.fiction.author = this.createFictionForm.value.author;
    this.fiction.isbn = this.createFictionForm.value.isbn;
    this.fiction.nrOfPages = this.createFictionForm.value.nrOfPages;
    this.fiction.bookType = this.createFictionForm.value.bookType;
    this.fiction.shortSummary = this.createFictionForm.value.shortSummary;
    this.fiction.fictionGenre = this.createFictionForm.value.fictionGenre;

    this.fictionService.createFiction(this.fiction);

  }
}
