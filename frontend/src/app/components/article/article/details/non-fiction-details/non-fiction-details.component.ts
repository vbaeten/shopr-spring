import {Component, OnInit} from '@angular/core';
import {OrderLine} from "../../../../../models/orderLine";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {ArticleService} from "../../../../../services/article.service";
import {OrderLineService} from "../../../../../services/order-line.service";
import {NonFiction} from "../../../../../models/nonFiction";
import {Article} from "../../../../../models/article";

@Component({
  selector: 'app-non-fiction-details',
  templateUrl: './non-fiction-details.component.html',
  styleUrls: ['./non-fiction-details.component.css']
})
export class NonFictionDetailsComponent implements OnInit {

  articleId: number;
  selectedArticle: NonFiction;
  orderLine: OrderLine;
  quantity: number;
  newOrderLine: OrderLine;
  cart: OrderLine[];
  submitQuantityForm: FormGroup = this.formBuilder.group(
    {
      quantity: ['1', Validators.required]
    });

  constructor(private route: Router, private activatedRoute: ActivatedRoute, private articleService: ArticleService, private orderLineService: OrderLineService, private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      this.articleId = +params['id'];
      this.articleService.getArticleById(this.articleId).subscribe(data => {
        this.selectedArticle = data as NonFiction;
      })
    })
  }

  submitQuantity() {
    this.cart = this.orderLineService.getCartFromStorage();
    if (this.cart === null) {
      this.cart = [];
    }
    this.newOrderLine = new OrderLine();
    this.newOrderLine.quantity = this.submitQuantityForm.value.quantity;
    this.newOrderLine.article = this.selectedArticle;
    this.newOrderLine.subtotal = this.newOrderLine.quantity * this.newOrderLine.article.price;
    this.orderLineService.addOrderLineToCartLocalStorage(this.cart, this.newOrderLine);

  }

  editArticle(article: Article) {

    switch (article.type) {
      case "game": {
        this.route.navigate(["/article/edit-game/", article.articleId])
      }
        break;
      case "lp": {
        this.route.navigate(["/article/edit-lp/", article.articleId])
      }
        break;
      case "fiction": {
        this.route.navigate(["/article/edit-fiction/", article.articleId])
      }
        break;
      case "nonFiction": {
        this.route.navigate(["/article/edit-nonFiction/", article.articleId])
      }
        break;
    }
    this.articleService.setArticleToStorage(article);
  }

}
