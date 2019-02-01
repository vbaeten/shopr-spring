import {Component, OnInit} from '@angular/core';
import {UserService} from "../../../services/user.service";
import {User} from "../../../models/user";
import {FormBuilder, FormControl} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User;
  firstName = '';
  name = '';

  registrationForm = this.formBuilder.group({})

  constructor(
    private userService: UserService,
    public formBuilder: FormBuilder,
  ) {

  }


  ngOnInit() {
    this.registrationForm.addControl(this.firstName, new FormControl()),
      this.registrationForm.addControl(this.name, new FormControl())
  }

  registerUser() {
    this.registrationForm.value.firstName,
      this.registrationForm.value.name,
      this.userService.registerUser(this.user)
  }

}
