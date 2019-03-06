import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {NonFiction} from "../../../../../models/nonFiction";
import {NonFictionSubject} from "../../../../../models/non-fiction-subject";
import {NonFictionService} from '../../../../../services/non-fiction.service';
import {ActivatedRoute} from "@angular/router";
import {ArticleService} from "../../../../../services/article.service";

@Component({
  selector: 'app-create-non-fiction',
  templateUrl: './create-non-fiction.component.html',
  styleUrls: ['./create-non-fiction.component.css']
})
export class CreateNonFictionComponent implements OnInit {

  @Input() type: string;
  nonFiction: NonFiction;
  articleId: number;
  selectedArticle: NonFiction = new NonFiction();
  createNonFictionForm: FormGroup;

  constructor(private nonFictionService: NonFictionService, private activatedRoute: ActivatedRoute, private articleService: ArticleService, private formBuilder: FormBuilder) {
  }

  nonFictionSubjects(): Array<string> {
    return Object.keys(NonFictionSubject).filter(
      (type) => isNaN(<any>type) && type !== 'values'
    );
  }

  ngOnInit() {
    this.fillInForm();
    this.activatedRoute.params.subscribe(params => {
      this.articleId = +params['id'];
      if (this.articleId) {
        this.articleService.getArticleById(this.articleId).subscribe(data => {
          this.selectedArticle = data as NonFiction;
          this.type = this.selectedArticle.type;
          this.fillInForm();
        })
      }
    });
  }

  createNonFiction = () => {
    this.nonFiction = new NonFiction();
    if (this.createNonFictionForm.value.id) {
      this.nonFiction.articleId = this.createNonFictionForm.value.id;
    }
    this.nonFiction.type = this.createNonFictionForm.value.type;
    this.nonFiction.title = this.createNonFictionForm.value.title;
    this.nonFiction.price = this.createNonFictionForm.value.price;
    this.nonFiction.supplierId = this.createNonFictionForm.value.supplierId;
    this.nonFiction.author = this.createNonFictionForm.value.author;
    this.nonFiction.isbn = this.createNonFictionForm.value.isbn;
    this.nonFiction.nrOfPages = this.createNonFictionForm.value.nrOfPages;
    this.nonFiction.nonFictionSubject = this.createNonFictionForm.value.nonFictionSubject;
    if (this.createNonFictionForm.value.id) {
      this.nonFictionService.edit(this.nonFiction.articleId, this.nonFiction);
    } else {
      this.nonFictionService.createNonFiction(this.nonFiction);
    }
  };

  validation_messages = {
    'title': [
      {type: 'required', message: 'Title is required'},
      {type: 'maxlength', message: 'Title cannot be more than 100 characters long'},
    ],
    'price': [
      {type: 'required', message: 'Price is required'},
      {type: 'max', message: 'Price cannot be more than $9999.99'},
    ],
    'supplierId': [
      {type: 'required', message: 'Supplier id is required'},
      {type: 'maxlength', message: 'Supplier id cannot be more than 100 characters long'},
    ],
    'author': [
      {type: 'required', message: 'Author is required'},
      {type: 'maxlength', message: 'Author cannot be more than 100 characters long'},
    ],
    'isbn': [
      {type: 'required', message: 'Isbn is required'},
      {type: 'maxlength', message: 'Isbn cannot be more than 13 characters long'},
    ],
    'nrOfPages': [
      {type: 'required', message: 'Nr. of pages is required'},
      {type: 'max', message: 'Nr. of pages cannot be more than 9999'},
    ],
    'nonFictionSubject': [
      {type: 'required', message: 'Non fiction subject is required'}
    ]
  };

  private fillInForm() {
    this.createNonFictionForm = this.formBuilder.group(
      {
        id: [this.selectedArticle.articleId],
        type: [this.type, Validators.required],
        title: [this.selectedArticle.title, Validators.compose([
          Validators.required, Validators.maxLength(100)
        ])],
        price: [this.selectedArticle.price, Validators.compose([
          Validators.required, Validators.max(9999.99)
        ])],
        supplierId: [this.selectedArticle.supplierId, Validators.compose([
          Validators.required, Validators.maxLength(100)
        ])],
        author: [this.selectedArticle.author, Validators.compose([
          Validators.required, Validators.maxLength(100)
        ])],
        isbn: [this.selectedArticle.isbn, Validators.compose([
          Validators.required, Validators.maxLength(17)
        ])],
        nrOfPages: [this.selectedArticle.nrOfPages, Validators.compose([
          Validators.required, Validators.max(9999)
        ])],
        nonFictionSubject: [this.selectedArticle.nonFictionSubject, Validators.required],
      });
  }

}
