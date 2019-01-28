import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {



  public users = []

  constructor(private userService:UserService) { }

  ngOnInit() {

    this.userService.getUsers()
      .subscribe(data =>this.users=data)
  }

}
