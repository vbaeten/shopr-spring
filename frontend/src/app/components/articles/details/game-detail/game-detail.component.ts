import {Component, OnInit} from '@angular/core';
import {Game} from '../../../../models/game';
import {GameService} from '../../../../services/game.service';
import {ActivatedRoute} from '@angular/router';
import {ShoppingCartService} from '../../../../services/shopping-cart.service';
import {NgForm} from '@angular/forms';
import {OrderLine} from '../../../../models/order-line';
import {Subscription} from "rxjs";
import {LoginService} from "../../../../services/login.service";
import {User} from "../../../../models/user";

@Component({
  selector: 'app-game-detail',
  templateUrl: './game-detail.component.html',
  styleUrls: ['./game-detail.component.css']
})
export class GameDetailComponent implements OnInit {

  private userSubscription: Subscription;
  game: Game;
  id: number;
  orderLine: OrderLine;
  currentUser: User;

  constructor(private gameService: GameService,
              private route: ActivatedRoute,
              private shoppingCartService: ShoppingCartService,
              private loginService: LoginService
  ) {
  }

  ngOnInit() {
    this.getGame();
    this.getCurrentUser();
  }

  getGame() {
    this.route.params.subscribe(params => this.id = params['id']);
    this.gameService.getGame(this.id).subscribe(game => this.game = game);
  }

  getCurrentUser() {
    this.loginService.getCurrentUser().then(user => this.currentUser = user);
  }

  addToCart(form: NgForm) {
    this.orderLine = new OrderLine();
    this.orderLine.quantity = form.value.quantity;
    this.orderLine.articleId = this.game.id;
    this.orderLine.userId = this.currentUser.id;
    this.shoppingCartService.addToCart(this.orderLine);
  }
}
