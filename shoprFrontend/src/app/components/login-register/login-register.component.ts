import { Component, OnInit } from '@angular/core';
import {FormGroup} from "@angular/forms";
import {User} from "../../models/user";

@Component({
  selector: 'app-login-register',
  templateUrl: './login-register.component.html',
  styleUrls: ['./login-register.component.css']
})
export class LoginRegisterComponent implements OnInit {

  loginRegisterForm:FormGroup;

  constructor() { }

  ngOnInit() {
  }

  login(){
    let user = new User();
    user.firstName= this.getFormControlValue('firstName');
  }



  getFormControlValue(formValue: string){
    return formValue ? this.loginRegisterForm.controls[formValue].value:null;
  }

}
