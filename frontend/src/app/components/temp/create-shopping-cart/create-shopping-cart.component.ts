import { Component, OnInit } from '@angular/core';
import {Cart} from "../../../models/cart";
import {ShoppingCartService} from "../../../services/shopping-cart.service";
import {User} from "../../../models/user";
import {LoginService} from "../../../services/login.service";

@Component({
  selector: 'app-create-shopping-cart',
  templateUrl: './create-shopping-cart.component.html',
  styleUrls: ['./create-shopping-cart.component.css']
})
export class CreateShoppingCartComponent implements OnInit {

  cart: Cart;
  currentUser: User = new User();

  constructor(private cartService: ShoppingCartService,
              private loginService: LoginService) {
  }

  ngOnInit() {
    this.getCurrentUser();

  }

  getCurrentUser() {
    this.loginService.getCurrentUser().then(user => this.currentUser = user);
  }

  createCart() {
    this.cart = new Cart();
    this.cart.userId = 5;
    this.cart.user = null;
    this.cartService.createCart(this.cart).subscribe();
  }
}
