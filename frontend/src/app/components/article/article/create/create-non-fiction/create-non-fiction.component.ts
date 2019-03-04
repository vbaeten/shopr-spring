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

    this.nonFictionService.createNonFiction(this.nonFiction);

  }

  private fillInForm() {
    this.createNonFictionForm = this.formBuilder.group(
      {
        type: [this.type, Validators.required],
        title: [this.selectedArticle.title, Validators.required],
        price: [this.selectedArticle.price, Validators.required],
        supplierId: [this.selectedArticle.supplierId, Validators.required],
        author: [this.selectedArticle.author, Validators.required],
        isbn: [this.selectedArticle.isbn, Validators.required],
        nrOfPages: [this.selectedArticle.nrOfPages, Validators.required],
        nonFictionSubject: [this.selectedArticle.nonFictionSubject, Validators.required],
      });
  }

}
