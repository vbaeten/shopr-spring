import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {User} from "../../models/user";

@Component({
  selector: 'app-login-register',
  templateUrl: './login-register.component.html',
  styleUrls: ['./login-register.component.css']
})
export class LoginRegisterComponent implements OnInit {

  registerForm:FormGroup;
  user:User;

  registerForm = this.fb.group(

  )



  constructor( fb:FormBuilder) { }

  ngOnInit() {
  }

  register(){

    this.user = new User(
      this.registerForm.value.
    )

  }





}
