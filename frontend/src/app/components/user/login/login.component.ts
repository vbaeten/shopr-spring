import { Component, OnInit } from '@angular/core';
import {User} from "../../../models/user";
import {UserService} from "../../../services/user.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  users: User[] = [];

  constructor(private userService: UserService) { }


  ngOnInit() {
    this.userService.getUsers().subscribe(users => {
      this.users = users;
    })
  }

}
