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
      title: ['', Validators.compose([
        Validators.required, Validators.maxLength(100)
      ])],
      price: ['', Validators.required, Validators.requiredTrue],
      supplierId: ['', Validators.required],
      author: ['', Validators.required],
      isbn: ['', Validators.required],
      nrOfPages: ['', Validators.required],
      shortSummary: ['', Validators.required],
      fictionGenre: ['', Validators.required],
    });

  constructor(private fictionService: FictionService,
              private formBuilder: FormBuilder) {
  }

  fictionGenres(): Array<string> {
    return Object.keys(FictionGenre).filter(
      (type) => isNaN(<any>type) && type !== 'values'
    );
  }

  ngOnInit() {
    this.createFictionForm.patchValue({type: this.type});
    this.createFictionForm.patchValue({bookType: this.type})
  }


  createFiction = () => {
    this.fiction = new Fiction();
    this.fiction.type = "fiction";
    this.fiction.title = this.createFictionForm.value.title;
    this.fiction.price = this.createFictionForm.value.price;
    this.fiction.supplierId = this.createFictionForm.value.supplierId;
    this.fiction.author = this.createFictionForm.value.author;
    this.fiction.isbn = this.createFictionForm.value.isbn;
    this.fiction.nrOfPages = this.createFictionForm.value.nrOfPages;
    this.fiction.shortSummary = this.createFictionForm.value.shortSummary;
    this.fiction.fictionGenre = this.createFictionForm.value.fictionGenre;

    this.fictionService.createFiction(this.fiction);

  }
}
