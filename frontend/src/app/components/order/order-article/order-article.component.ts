import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {OrderLine} from '../../../models/order-line';
import {ShoppingCartService} from '../../../services/shopping-cart.service';
import {Article} from '../../../models/article';
import {ActivatedRoute} from '@angular/router';
import {ArticleService} from '../../../services/article.service';
import {User} from '../../../models/user';
import {UserService} from '../../../services/user.service';
import {LoginService} from '../../../services/login.service';

@Component({
  selector: 'app-order-article',
  templateUrl: './order-article.component.html',
  styleUrls: ['./order-article.component.css']
})
export class OrderArticleComponent implements OnInit {

  id: number;
  orderLine: OrderLine;
  article: Article;
  currentUser: User;
  quantity = 1;

  constructor(private shoppingCartService: ShoppingCartService,
              private route: ActivatedRoute,
              private articleService: ArticleService,
              private loginService: LoginService) { }

  ngOnInit() {
    this.getArticle();
  }

  getArticle() {
    this.route.params.subscribe(params => this.id = params['id']);
    this.articleService.getArticleById(this.id).subscribe(article => this.article = article);
    this.loginService.getCurrentUser();
  }

  addToCart(form: NgForm) {
    this.orderLine = new OrderLine();
    this.orderLine.articleId = this.article.id;
    this.orderLine.quantity = form.value.quantity;
    this.orderLine.userId = this.currentUser.id;
    this.shoppingCartService.addToCart(this.orderLine).subscribe(data => this.orderLine = data);
  }
}
