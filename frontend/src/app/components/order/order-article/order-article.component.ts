import {Component, Input, OnInit} from '@angular/core';
import {NgForm, Validators} from '@angular/forms';
import {OrderLine} from '../../../models/order-line';
import {ShoppingCartService} from '../../../services/shopping-cart.service';
import {Article} from '../../../models/article';
import {ActivatedRoute} from '@angular/router';
import {ArticleService} from '../../../services/article.service';
import {User} from '../../../models/user';
import {LoginService} from '../../../services/login.service';
import {Cart} from '../../../models/cart';

@Component({
  selector: 'app-order-article',
  templateUrl: './order-article.component.html',
  styleUrls: ['./order-article.component.css']
})
export class OrderArticleComponent implements OnInit {

  @Input() currentUser: User;

  id: number;
  orderLine: OrderLine;
  cart: Cart;

  quantity = [1, Validators.min(10)];

  @Input() article: Article;

  constructor(private shoppingCartService: ShoppingCartService,
              private route: ActivatedRoute,
              private articleService: ArticleService,
              private loginService: LoginService) {
  }

  ngOnInit() {
    this.getArticle();
    this.getCurrentUser();
  }

  getCurrentUser() {
    this.loginService.getCurrentUser().then(user => this.currentUser = user);
  }

  getArticle() {
    this.route.params.subscribe(params => this.id = params['id']);
    this.articleService.getArticleById(this.id).subscribe(article => this.article = article);
  }

  addToCart(form: NgForm) {
    this.orderLine = new OrderLine();
    this.orderLine.article = this.article;
    this.orderLine.quantity = form.value.quantity;
    this.orderLine.subTotal = form.value.quantity * this.article.price;
    this.orderLine.user = this.currentUser;
    this.shoppingCartService.addToCart(this.orderLine);
  }

}
