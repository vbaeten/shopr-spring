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
  newUser: User;
  newId;

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
    this.userService.registerUser(this.user).subscribe(data => {
      this.refresh();
      this.user = data;
    });
    // this.cart = new Cart();
    // this.cart.user = this.user.id;
    // this.cartService.createCart(this.cart).subscribe(data => this.cart = data);
  }


  refresh() {
    this.userService.getUsers().subscribe(data => {
      this.users = data;
      this.dataSource = this.users;
    });
  }
}

