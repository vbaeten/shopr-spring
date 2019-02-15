import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {User} from "../../models/user";
import {NavBarService} from "../../services/nav-bar.service";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {



  public users = []
  selectedUser:User
  isLoggedIn=false



  constructor(private userService:UserService, private navBarService:NavBarService) {
    this.navBarService.getLoginStatus().subscribe(status=>this.isLoggedIn=status)
  }

  ngOnInit() {

    this.userService.getUsers()
      .subscribe(data =>{
        this.users=data;
      })
  }

  loginUser(){

    this.userService.loginUser(this.selectedUser)

  }




}
