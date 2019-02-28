import {Component, OnInit} from '@angular/core';
import {Lp} from "../../../../../models/lp";
import {ActivatedRoute} from "@angular/router";
import {ArticleService} from "../../../../../services/article.service";
import {OrderLine} from "../../../../../models/orderLine";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {OrderLineService} from "../../../../../services/order-line.service";

@Component({
  selector: 'app-lp-details',
  templateUrl: './lp-details.component.html',
  styleUrls: ['./lp-details.component.css']
})
export class LpDetailsComponent implements OnInit {
  articleId: number;
  selectedArticle: Lp;
  orderLine: OrderLine;
  quantity: number;
  newOrderLine: OrderLine;
  cart: OrderLine[];
  submitQuantityForm: FormGroup = this.formBuilder.group(
    {
      quantity: ['1', Validators.required]
    });

  constructor(private route: ActivatedRoute, private articleService: ArticleService, private orderLineService: OrderLineService, private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.articleId = +params['id'];
      this.articleService.getArticleById(this.articleId).subscribe(data => {
        this.selectedArticle = data as Lp;
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

}
