import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Fiction} from "../../../../../models/fiction";
import {FictionGenre} from "../../../../../models/fiction-genre";
import {FictionService} from "../../../../../services/fiction.service";
import {ActivatedRoute} from "@angular/router";
import {ArticleService} from "../../../../../services/article.service";
import {ValidateDuplicateIsbn} from "../../../../../validators/duplicate-isbn.directive";

@Component({
  selector: 'app-create-fiction',
  templateUrl: './create-fiction.component.html',
  styleUrls: ['./create-fiction.component.css']
})
export class CreateFictionComponent implements OnInit {

  @Input() type: string;
  fiction: Fiction;
  articleId: number;
  selectedArticle: Fiction = new Fiction();
  createFictionForm: FormGroup;

  constructor(private fictionService: FictionService, private articleService: ArticleService, private activatedRoute: ActivatedRoute,
              private formBuilder: FormBuilder) {
  }

  fictionGenres(): Array<string> {
    return Object.keys(FictionGenre).filter(
      (type) => isNaN(<any>type) && type !== 'values'
    );
  }

  ngOnInit() {
    this.fillInForm();
    this.activatedRoute.params.subscribe(params => {
      this.articleId = +params['id'];
      if (this.articleId) {
        this.articleService.getArticleById(this.articleId).subscribe(data => {
          this.selectedArticle = data as Fiction;
          this.type = this.selectedArticle.type;
          this.fillInForm();
        })
      }
    });
  }

  validation_messages = {
    'title': [
      {type: 'required', message: 'Title is required'},
      {type: 'maxlength', message: 'Title cannot be more than 100 characters long'},
    ],
    'price': [
      {type: 'required', message: 'Price is required'},
      {type: 'min', message: 'Price must be at least $0.01'},
      {type: 'max', message: 'Price cannot be more than $9999.99'}
    ],
    'supplierId': [
      {type: 'required', message: 'Supplier id is required'},
      {type: 'maxlength', message: 'Supplier id cannot be more than 100 characters long'},
    ],
    'author': [
      {type: 'maxlength', message: 'Author cannot be more than 100 characters long'}
    ],
    'isbn': [
      {type: 'required', message: 'Isbn is required'},
      {type: 'maxlength', message: 'Isbn cannot be more than 13 characters long'},
      {type: 'isDuplicate', message: 'Isbn already exists'}
    ],
    'nrOfPages': [
      {type: 'min', message: 'Nr. of pages cannot be less than 1'},
      {type: 'max', message: 'Nr. of pages cannot be more than 9999'},
      {type: 'pattern', message: 'Nr. of pages must contain only numbers'}
    ],
    'shortSummary': [
      {type: 'maxlength', message: 'Short summary cannot be more than 255 characters long'}
    ],
    'fictionGenre': [
      {type: 'required', message: 'Fiction genre is required'}
    ]
  };

  createFiction = () => {
    this.fiction = new Fiction();
    if (this.createFictionForm.value.id) {
      this.fiction.articleId = this.createFictionForm.value.id;
    }
    this.fiction.type = this.createFictionForm.value.type.toLowerCase();
    this.fiction.title = this.createFictionForm.value.title;
    this.fiction.price = this.createFictionForm.value.price;
    this.fiction.supplierId = this.createFictionForm.value.supplierId;
    this.fiction.author = this.createFictionForm.value.author;
    this.fiction.isbn = this.createFictionForm.value.isbn;
    this.fiction.nrOfPages = this.createFictionForm.value.nrOfPages;
    this.fiction.shortSummary = this.createFictionForm.value.shortSummary;
    this.fiction.fictionGenre = this.createFictionForm.value.fictionGenre;

    if (this.createFictionForm.value.id) {
      this.fictionService.edit(this.fiction.articleId, this.fiction);
    } else {
      this.fictionService.createFiction(this.fiction);
    }
  };

  private fillInForm() {
    let controlsConfig = {
      id: [this.selectedArticle.articleId],
      type: [this.type, Validators.required],
      title: [this.selectedArticle.title, Validators.compose([
        Validators.required, Validators.maxLength(100)
      ])],
      price: [this.selectedArticle.price, Validators.compose([
        Validators.required, Validators.min(0.01), Validators.max(9999.99)
      ])],
      supplierId: [this.selectedArticle.supplierId, Validators.compose([
        Validators.required, Validators.maxLength(100)
      ])],
      author: [this.selectedArticle.author, Validators.compose([
        Validators.maxLength(100)
      ])],
      isbn: [this.selectedArticle.isbn, Validators.compose([
        Validators.required
      ])],
      nrOfPages: [this.selectedArticle.nrOfPages, Validators.compose([
        Validators.min(1), Validators.max(9999), Validators.pattern('[0-9]*')
      ])],
      shortSummary: [this.selectedArticle.shortSummary, Validators.compose([
        Validators.maxLength(255)
      ])],
      fictionGenre: [this.selectedArticle.fictionGenre, Validators.required],
    };
    this.createFictionForm = this.formBuilder.group(controlsConfig);

    if (this.articleId !== undefined) {
      this.fictionService.getFictionById(this.articleId).subscribe(book => {
        this.createFictionForm.setControl('isbn', new FormControl(this.selectedArticle.isbn, [
          Validators.required, Validators.maxLength(17), ValidateDuplicateIsbn.isDuplicate(this.articleId, book)
        ]));
      });
    } else {
      this.createFictionForm.setControl('isbn', new FormControl(this.selectedArticle.isbn, [
        Validators.required, Validators.maxLength(17), ValidateDuplicateIsbn.isDuplicate(this.articleId)
      ]));
    }


    console.log(this.createFictionForm.controls["isbn"]);
    // if (this.articleId) {
    //   controlsConfig.isbn = [this.selectedArticle.isbn, Validators.compose([
    //     Validators.required, Validators.maxLength(17)])];
    //   this.createFictionForm = this.formBuilder.group(controlsConfig);
    // }
  }

}
