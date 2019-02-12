import { Component, OnInit } from '@angular/core';
import {User} from '../../../models/user';
import {UserService} from '../../../services/user.service';
import {LoginService} from '../../../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  users: User[] = [];
  currentUser: User;

  constructor(private userService: UserService, private loginService: LoginService) { }


  ngOnInit() {
    this.refresh();
  }

  onSubmit() {
    this.loginService.login(this.currentUser);
    this.refresh();
    console.log(this.currentUser);
  }

  refresh() {
    this.userService.getUsers().subscribe(users => {
      this.users = users;
    });
  }
}
