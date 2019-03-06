import {Component, OnInit} from '@angular/core';
import {UserService} from "../../../services/user.service";
import {User} from "../../../models/user";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ValidateDuplicate} from "../../../validators/duplicate-user.directive";

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

  validation_messages = {
    'userName': [
      {type: 'required', message: 'Username is required'},
      {type: 'minlength', message: 'Username must be at least 3 characters long'},
      {type: 'maxlength', message: 'Username cannot be more than 30 characters long'},
      // {type: 'pattern', message: 'Your username must contain only numbers and letters'},
      {type: 'isDuplicate', message: 'Your username has already been taken'}
    ],
      'firstName':[
        {type: 'required', message: 'First name is required'},
        {type: 'maxlength', message: 'First name cannot be more than 50 characters long'},
      ],
    'name':[
      {type: 'required', message: 'Last name is required'},
      {type: 'maxlength', message: 'Last name cannot be more than 50 characters long'},
    ]
  };

  ngOnInit() {
    this.registerUserForm = this.formBuilder.group({
      userName: ['', Validators.compose([
        Validators.required, Validators.minLength(3), Validators.maxLength(30), ValidateDuplicate.isDuplicate]
      )],
      firstName: ['', Validators.compose([
        Validators.required, Validators.maxLength(50)
      ])],
      name: ['', Validators.compose([
        Validators.required, Validators.maxLength(50)
      ])],
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

  }
}
