import {Component, ElementRef, OnInit} from '@angular/core';
import {UserService} from '../../../services/user.service';
import {User} from '../../../models/user';
import {FormBuilder, FormControl, FormGroup, NgForm, Validators} from '@angular/forms';
import {ShoppingCartService} from '../../../services/shopping-cart.service';
import {Cart} from '../../../models/cart';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  dataSource;
  user: User;
  users: User[];
  cart: Cart;

  constructor(private userService: UserService,
              private cartService: ShoppingCartService) {
  }

  ngOnInit() {
    this.refresh();
  }

  onSubmit(form: NgForm) {
    this.user = new User();
    this.user.firstName = form.value.firstName;
    this.user.name = form.value.name;
    this.userService.registerUser(this.user).subscribe(data => this.refresh);
  }

  createCart() {
    this.cart = new Cart();
    this.cart.userId = this.user.id;
    this.cart.user = this.user;
    this.cartService.createCart(this.cart);
  }

  refresh() {
    this.userService.getUsers().subscribe(data => {
      this.users = data;
      this.dataSource = this.users;
    });
  }
}

