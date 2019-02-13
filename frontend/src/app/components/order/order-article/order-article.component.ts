import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import {OrderLine} from '../../../models/order-line';
import {ShoppingCartService} from '../../../services/shopping-cart.service';
import {Article} from '../../../models/article';
import {ActivatedRoute} from '@angular/router';
import {ArticleService} from '../../../services/article.service';
import {User} from '../../../models/user';
import {LoginService} from '../../../services/login.service';
import {Game} from "../../../models/game";
import {Fiction} from "../../../models/fiction";
import {FictionService} from "../../../services/fiction.service";
import {Subscription} from "rxjs";
import {UserService} from "../../../services/user.service";

@Component({
  selector: 'app-order-article',
  templateUrl: './order-article.component.html',
  styleUrls: ['./order-article.component.css']
})
export class OrderArticleComponent implements OnInit, OnDestroy {

  id: number;
  orderLine: OrderLine;
  currentUser;
  private userSubscription: Subscription;

  @Input() article: Article;

  @Input() game: Game;

  @Input() fiction: Fiction;

  // @Input() currentUser: User;

  quantity = 1;

  constructor(private shoppingCartService: ShoppingCartService,
              private route: ActivatedRoute,
              private articleService: ArticleService,
              private fictionService: FictionService,
              private loginService: LoginService,
              private userService: UserService) { }

  ngOnInit() {
    this.getArticle();
    this.getUser();
    this.loginService.getCurrentUser().then(user => this.currentUser = user);  }

  getUser() {
    this.route.params.subscribe(params => this.id = params['id']);
    this.userService.getUser(this.id).subscribe(user => this.currentUser = user);
  }

  getArticle() {
    this.route.params.subscribe(params => this.id = params['id']);
    this.articleService.getArticleById(this.id).subscribe(article => this.article = article);
    this.loginService.getCurrentUser().then(user => this.currentUser = user);
  }

  getFiction() {
    this.route.params.subscribe(params => this.id = params['id']);
    this.fictionService.getFiction(this.id).subscribe(fiction => this.fiction = fiction);
  }

  addToCart(form: NgForm) {
    this.orderLine = new OrderLine();
    this.orderLine.articleId = this.article.id;
    this.orderLine.quantity = form.value.quantity;
    this.orderLine.userId = this.currentUser.id;
    this.shoppingCartService.addToCart(this.orderLine).subscribe(data => this.orderLine = data);
  }

  ngOnDestroy(): void {
    this.userSubscription.unsubscribe();
  }
}
