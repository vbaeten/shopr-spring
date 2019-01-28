import {Component} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {User} from "./models/user";
import {UserService} from './services/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular';
  user: User;

  registrationForm = this.formBuilder.group({
    firstname: ['', Validators.required],
    name: ['', Validators.required],

  });

  constructor(private userService: UserService, private formBuilder: FormBuilder) {

  }

  registerUser() {
    this.user = new User(
      this.registrationForm.value.firstName,
      this.registrationForm.value.name);
    this.userService.registerUser(this.user);

  }
}
