import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {DataService} from "../../services/data.service";
import {User} from "../../models/user";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {



  public users = []
  selectedUser

  constructor(private userService:UserService, private dataService:DataService, private router:Router) { }

  ngOnInit() {

    this.userService.getUsers()
      .subscribe(data =>this.users=data)
  }

  login(){

    this.dataService.changeUser(this.selectedUser)
    this.router.navigate(['/itemsOverview'])
  }

}
