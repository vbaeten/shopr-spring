import { Component, OnInit } from '@angular/core';
import {User} from "../../../../models/user";
import {LoginService} from "../../../../services/login.service";
import {NgForm} from "@angular/forms";
import {UserService} from "../../../../services/user.service";

@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {

  dataSource;
  currentUser: User;
  user: User;

  constructor(private loginService: LoginService,
              private userService: UserService) { }

  ngOnInit() {
    this.getCurrentUser();
  }

  getCurrentUser() {
    this.loginService.getCurrentUser().then(user => {
      this.currentUser = user;
    });
  }

  onSubmit(form: NgForm) {
    this.currentUser.firstName = form.value.firstName;
    this.currentUser.name = form.value.name;
    this.userService.registerUser(this.currentUser).subscribe(data => this.getCurrentUser());
    this.loginService.login(this.currentUser);
  }
}
