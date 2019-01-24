import { Component, OnInit } from '@angular/core';
import {FormsModule, NgForm} from "@angular/forms";
import {User} from "../../models/user";

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  user
  firstName:string


  constructor() { }

  ngOnInit() {
  }

  register(form:NgForm){
    this.user = new User()
    this.user.firstName = form.value.firstName
    this.user.lastName = form.value.lastName
    this.user.userName = form.value.userName
    console.log(this.user);
  }

}
