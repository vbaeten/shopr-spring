import {Component, OnInit} from '@angular/core';
import {ArticleService} from "../../services/article.service";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../services/user.service";
import {User} from "../../domain/user";
import {Orderline} from "../../domain/orderline";
import {OrderService} from "../../services/order.service";
import {Order} from "../../domain/order";
import {OrderStatus} from "../../domain/orderStatus";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  article: any = {};
  articleId: number;
  currentUser: User;
  orderline: Orderline;
  subTotal: number;
  quantity: number;

  constructor(private orderService: OrderService, private articleService: ArticleService, private userService: UserService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.articleId = this.route.snapshot.params['articleId'];
    // this.route.params.subscribe(params => this.articleId = params['articleId']);
    this.articleService.getArticleById(this.articleId).subscribe(article => this.article = article);
    this.userService.getCurrentUser().then(user => this.currentUser = user);
    this.userService.userSubject.subscribe(sessionUser => {
      console.log(sessionUser);
      this.currentUser = sessionUser;
    });
  }

  deleteArticleById() {
    this.articleService.deleteArticleById(this.articleId).subscribe();
    this.router.navigate(['/articles']);
  }

  goToEdit() {
    this.router.navigate(['/edit' + this.article.type, this.articleId])
  }

  addToOrder() {
    this.orderService.findCurrentCartByUserId(this.currentUser.userId).subscribe(data => {
      console.log('first time');
      console.log(data);
      let order: Order;
      if (data) {
        order = data;
      } else {
        order = new Order(OrderStatus.IN_CART, this.currentUser, []);
      }
      console.log(order);
      let tempOrderline = new Orderline(this.article, this.quantity);
      order.orderlineList.push(tempOrderline);

      this.orderService.saveOrder(order).subscribe(data => {
          this.router.navigate(['/shoppingcart'])
        },
        error1 => {
          alert("orderline failed")
        });
    });
  }

}
