import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {NonFiction} from "../../../../../models/nonFiction";
import {NonFictionSubject} from "../../../../../models/non-fiction-subject";
import {NonFictionService} from '../../../../../services/non-fiction.service';

@Component({
  selector: 'app-create-non-fiction',
  templateUrl: './create-non-fiction.component.html',
  styleUrls: ['./create-non-fiction.component.css']
})
export class CreateNonFictionComponent implements OnInit {

  @Input() type: string;
  nonFiction: NonFiction;
  createNonFictionForm: FormGroup = this.formBuilder.group(
    {
      type: ['', Validators.required],
      title: ['', Validators.required],
      price: ['', Validators.required],
      supplierId: ['', Validators.required],
      author: ['', Validators.required],
      isbn: ['', Validators.required],
      nrOfPages: ['', Validators.required],
      bookType: ['', Validators.required],
      nonFictionSubject: ['', Validators.required],
    });

  constructor(private nonFictionService: NonFictionService,
              private formBuilder: FormBuilder) {
  }

  nonFictionSubjects(): Array<string> {
    return Object.keys(NonFictionSubject).filter(
      (type) => isNaN(<any>type) && type !== 'values'
    );
  }

  ngOnInit() {
    this.createNonFictionForm.patchValue({type: this.type});
    this.createNonFictionForm.patchValue({bookType: this.type})
  }


  createNonFiction = () => {
    this.nonFiction = new NonFiction();
    this.nonFiction.type = this.createNonFictionForm.value.type;
    this.nonFiction.title = this.createNonFictionForm.value.title;
    this.nonFiction.price = this.createNonFictionForm.value.price;
    this.nonFiction.supplierId = this.createNonFictionForm.value.supplierId;
    this.nonFiction.author = this.createNonFictionForm.value.author;
    this.nonFiction.isbn = this.createNonFictionForm.value.isbn;
    this.nonFiction.nrOfPages = this.createNonFictionForm.value.nrOfPages;
    this.nonFiction.bookType = this.createNonFictionForm.value.bookType;
    this.nonFiction.nonFictionSubject = this.createNonFictionForm.value.nonFictionSubject;

    this.nonFictionService.createNonFiction(this.nonFiction);

  }
}
