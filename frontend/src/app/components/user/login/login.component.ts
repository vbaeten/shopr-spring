import {Component, OnInit} from '@angular/core';
import {UserService} from "../../../services/user.service";
import {User} from "../../../models/user";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {OrderService} from "../../../services/order.service";
import {Order} from "../../../models/order";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User;
  loginForm: FormGroup;

  constructor(private userService: UserService, private formBuilder: FormBuilder, private orderService: OrderService, private router: Router) {
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      userName: ['', Validators.required]
    });
  }

  login() {
    this.userService.getUserByUserName(this.loginForm.value.userName).subscribe(data => {
      this.user = data;
      this.userService.setCurrentUser(this.user);
      let currentOrder: Order = JSON.parse(localStorage.getItem('currentOrder'));
      let currentUser: User = JSON.parse(localStorage.getItem('currentUser'));
      if (currentOrder.user === undefined) {
        currentOrder.user = currentUser;
        localStorage.setItem('currentOrder', JSON.stringify(currentOrder))
      }
      this.router.navigate(["/articles/"])
    });
  }

}
