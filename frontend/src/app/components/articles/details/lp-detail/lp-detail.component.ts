import { Component, OnInit } from '@angular/core';
import {Lp} from '../../../../models/lp';
import {LpService} from '../../../../services/lp.service';
import {ActivatedRoute} from "@angular/router";
import {ShoppingCartService} from "../../../../services/shopping-cart.service";
import {OrderLine} from "../../../../models/order-line";
import {NgForm} from "@angular/forms";
import {LoginService} from "../../../../services/login.service";
import {User} from "../../../../models/user";

@Component({
  selector: 'app-lp-detail',
  templateUrl: './lp-detail.component.html',
  styleUrls: ['./lp-detail.component.css']
})
export class LpDetailComponent implements OnInit {

  lp: Lp;
  id: number;
  orderLine: OrderLine;
  currentUser: User;

  constructor(private lpService: LpService,
              private route: ActivatedRoute,
              private shoppingCartService: ShoppingCartService,
              private loginService: LoginService) { }

  ngOnInit() {
    this.getLp();
    this.loginService.getCurrentUser().then(user => this.currentUser = user);
  }

  getLp() {
    this.route.params.subscribe(params => this.id = params['id']);
    this.lpService.getLp(this.id).subscribe(lp => this.lp = lp);
  }

  addToCart(form: NgForm) {
    this.orderLine = new OrderLine();
    this.orderLine.articleId = this.lp.id;
    this.orderLine.quantity = form.value.quantity;
    this.orderLine.userId = this.currentUser.id;
    this.shoppingCartService.addToCart(this.orderLine);
  }
}
