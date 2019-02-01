import { Component, OnInit } from '@angular/core';
import {UserService} from "../../../services/user.service";
import {User} from "../../../models/user";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User;
  registerUserForm: FormGroup;




  constructor(private userService: UserService, private formBuilder: FormBuilder) {

  }

  ngOnInit() {
    this.registerUserForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      name: ['', Validators.required]/*,
      isAdmin: [false,Validators.required],
      isLoggedIn: [true]*/
    });
  }

  registerUser() {
    this.user = new User(
      this.registerUserForm.value.firstName,
      this.registerUserForm.value.name/*,
      this.registerUserForm.value.isAdmin,
      this.registerUserForm.value.isLoggedIn*/);

    console.log(this.user);

    this.userService.registerUser(this.user);

  }


}
