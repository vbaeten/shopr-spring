import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {OrderLine} from '../../../models/order-line';
import {ShoppingCartService} from '../../../services/shopping-cart.service';
import {Article} from "../../../models/article";
import {ActivatedRoute} from "@angular/router";
import {ArticleService} from "../../../services/article.service";

@Component({
  selector: 'app-order-article',
  templateUrl: './order-article.component.html',
  styleUrls: ['./order-article.component.css']
})
export class OrderArticleComponent implements OnInit {

  id: number;
  orderLine: OrderLine;
  article: Article;

  constructor(private shoppingCartService: ShoppingCartService, private route: ActivatedRoute, private articleService: ArticleService) { }

  ngOnInit() {
    this.getArticle();
  }

  getArticle() {
    this.route.params.subscribe(params => this.id = params['id']);
    this.articleService.getArticleById(this.id).subscribe(article => this.article = article);
  }

  addToCart(form: NgForm) {
    this.orderLine = new OrderLine();
    this.orderLine.articleId = this.article.id;
    this.orderLine.quantity = form.value.quantity;
    this.shoppingCartService.addToCart(this.orderLine).subscribe(data => this.orderLine = data);
  }
}
