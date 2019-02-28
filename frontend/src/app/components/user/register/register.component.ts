import {Component, OnInit} from '@angular/core';
import {UserService} from "../../../services/user.service";
import {User} from "../../../models/user";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User;
  registerUserForm: FormGroup;


  constructor(private userService: UserService, private formBuilder: FormBuilder, private router: Router) {

  }

  ngOnInit() {
    this.registerUserForm = this.formBuilder.group({
      userName: ['', Validators.required],
      firstName: ['', Validators.required],
      name: ['', Validators.required],
      admin: [false, Validators.required],
    });
  }

  registerUser() {
    this.user = new User();
      this.user.userName = this.registerUserForm.value.userName;
      this.user.firstName = this.registerUserForm.value.firstName;
      this.user.name = this.registerUserForm.value.name;
      this.user.admin = this.registerUserForm.value.admin;
    this.user.loggedin = true;
    this.userService.registerUser(this.user);
    this.userService.getUsers();

    // let currentUser: User = JSON.parse(localStorage.getItem('currentUser'));
    // if (currentOrder.user === undefined) {
    //   currentOrder.user = currentUser;
    //   localStorage.setItem('currentOrder', JSON.stringify(currentOrder))
    // }

  }


}
