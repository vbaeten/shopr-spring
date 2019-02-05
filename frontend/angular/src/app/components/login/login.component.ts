import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";
import {User} from "../../domain/User";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  firstName: string;
  lastName: string;
  loggedIn: boolean;
  admin: boolean;
  checked = false;
  indeterminate = false;
  userName: string;

  constructor(private service: UserService, public router: Router) {
  }

  ngOnInit() {
  }

  submit() {
    let newUser = new User(this.firstName, this.lastName, this.userName, this.loggedIn, this.admin);
    this.service.register(newUser);
    this.router.navigate(['/articles']);
  }
}
