import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {FormBuilder, Validators} from "@angular/forms";

import {AuthService} from "../../../services/auth.service";
import {UserService} from "../../../services/user.service";
import {User} from "../../../models/users.model";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User;

  registrationForm = this.fb.group({
    username: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(20)]],
    firstname: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(20)]],
    lastname: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(20)]],
    password: ['', [Validators.required,Validators.minLength(5),Validators.maxLength(20)]],
    confirmPassword: ['', [Validators.required,Validators.minLength(5),Validators.maxLength(20)]],
  })

  constructor(private auth: AuthService, private userService: UserService, private router: Router, private fb: FormBuilder) { }

  ngOnInit() {
  }

  registerUser() {
    if(this.registrationForm.value.password != this.registrationForm.value.confirmPassword) {
      alert("Passwords don't match");
    } else {
      this.user = new User();
      this.user.username = this.registrationForm.value.username;
      this.user.firstname = this.registrationForm.value.firstname;
      this.user.lastname = this.registrationForm.value.lastname;
      this.user.password = this.registrationForm.value.password;
      this.user.active = true;
    }
    this.userService.registerUser(this.user);
    this.router.navigate(['login']);
    console.log("User: " + JSON.stringify(this.user));
  }

}
