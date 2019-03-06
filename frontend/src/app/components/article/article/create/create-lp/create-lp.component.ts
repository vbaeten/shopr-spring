import {Component, Input, OnInit} from '@angular/core';
import {Lp} from "../../../../../models/lp";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {LpGenre} from "../../../../../models/lp-genre";
import {LpService} from "../../../../../services/lp.service";
import {ActivatedRoute} from "@angular/router";
import {ArticleService} from "../../../../../services/article.service";

@Component({
  selector: 'app-create-lp',
  templateUrl: './create-lp.component.html',
  styleUrls: ['./create-lp.component.css']
})
export class CreateLpComponent implements OnInit {

  @Input() type: string;
  lp: Lp;
  articleId: number;
  selectedArticle: Lp = new Lp();
  createLpForm: FormGroup;

  constructor(private lpService: LpService, private activatedRoute: ActivatedRoute,
              private articleService: ArticleService, private formBuilder: FormBuilder) {
  }

  lpGenres(): Array<string> {
    return Object.keys(LpGenre).filter(
      (type) => isNaN(<any>type) && type !== 'values'
    );
  }

  ngOnInit() {
    this.fillInForm();
    this.activatedRoute.params.subscribe(params => {
      this.articleId = +params['id'];
      if (this.articleId) {
        this.articleService.getArticleById(this.articleId).subscribe(data => {
          this.selectedArticle = data as Lp;
          this.type = this.selectedArticle.type;
          this.fillInForm();
        })
      }
    });

  }

  createLp = () => {
    this.lp = new Lp();
    if (this.createLpForm.value.id) {
      this.lp.articleId = this.createLpForm.value.id;
    }
    this.lp.type = this.createLpForm.value.type.toLowerCase();
    this.lp.title = this.createLpForm.value.title;
    this.lp.price = this.createLpForm.value.price;
    this.lp.supplierId = this.createLpForm.value.supplierId;
    this.lp.publisher = this.createLpForm.value.publisher;
    this.lp.lpGenre = this.createLpForm.value.lpGenre;
    if (this.createLpForm.value.id) {
      this.lpService.edit(this.lp.articleId, this.lp)
    }
    this.lpService.createLp(this.lp);

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
    'publisher': [
      {type: 'required', message: 'Publisher is required'},
      {type: 'maxlength', message: 'Publisher cannot be more than 100 characters long'},
    ],
    'minimumAge': [
      {type: 'required', message: 'Minimum age is required'}
    ],
    'lpGenre': [
      {type: 'required', message: 'Lp genre is required'}
    ]
  };

  private fillInForm() {
    this.createLpForm = this.formBuilder.group(
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
        publisher: [this.selectedArticle.publisher, Validators.compose([
          Validators.required, Validators.maxLength(100)
        ])],
        lpGenre: [this.selectedArticle.lpGenre, Validators.required],
      });
  }

}
