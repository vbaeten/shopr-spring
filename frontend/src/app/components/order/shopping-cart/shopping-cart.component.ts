import { Component, OnInit } from '@angular/core';
import {User} from '../../../models/user';
import {LoginService} from '../../../services/login.service';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  currentUser: User = new User();

  constructor(private loginService: LoginService) { }

  ngOnInit() {
    this.getCurrentUser();
  }

  getCurrentUser() {
    this.loginService.getCurrentUser().then(user => {
      this.currentUser = user;
    });
  }
}
