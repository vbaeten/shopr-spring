import { Component, OnInit } from '@angular/core';
import {FormsModule, NgForm} from "@angular/forms";
import {User} from "../../models/user";
import {UserService} from "../../services/user.service";
import {DataService} from "../../services/data.service";

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  user

  constructor(private userService:UserService, private dataService:DataService) { }

  ngOnInit() {
  }

  register(form:NgForm){
    this.user = new User()
    this.user.firstName = form.value.firstName
    this.user.lastName = form.value.lastName
    this.user.userName = form.value.userName
    this.userService.registerUser(this.user)
                    .subscribe(data =>this.user=data)


  }

  showSnackBar(){
    let message= 'successfully registered your account'
    let action= ''
    this.dataService.openSnackBar(message,action)
  }

}
