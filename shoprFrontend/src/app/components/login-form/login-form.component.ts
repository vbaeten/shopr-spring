import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  //make local list

  public users = []

  constructor(private userService:UserService) { }

  ngOnInit() {
    //observable ( user service)
    this.userService.getUsers()
      .subscribe(data =>this.users=data)
  }

}
