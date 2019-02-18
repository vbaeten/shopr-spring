import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material";

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  private userName: string;

  constructor(private snackBar: MatSnackBar, private userService: UserService, public router: Router) {
  }

  viewSnackBar() {
    let message = 'This username is not found, please try again or register first.';
    let action = '';
    this.userService.getSnackBar(message, action)
  }

  login() {
    this.userService.login(this.userName)
      .then(() => this.router.navigate(['/articles']))
      .catch(error => this.viewSnackBar());
  }
  ngOnInit() {
  }

}
