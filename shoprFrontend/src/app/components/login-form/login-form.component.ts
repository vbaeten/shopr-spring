import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {User} from "../../models/user";
import {DataService} from "../../services/data.service";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {



  public users = []
  selectedUser:User

  constructor(private userService:UserService, private dataService: DataService) { }

  ngOnInit() {

    this.userService.getUsers()
      .subscribe(data =>this.users=data)
  }

  login(){
    this.userService.login(this.selectedUser)
  }


}
