import {Component, OnInit} from '@angular/core';
import {UserService} from '../../../services/user.service';
import {User} from '../../../models/user';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private userService: UserService) {
  }

  ngOnInit() {
  }

  onSubmit(form: NgForm) {
    const user = new User();
    user.firstName = form.value.firstName;
    user.name = form.value.name;
    this.userService.registerUser(user);
  }
}

