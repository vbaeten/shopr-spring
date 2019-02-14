import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";
import {User} from "../../domain/user";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  firstName: string;
  lastName: string;
  admin: boolean;
  checked = false;
  indeterminate = false;
  labelPosition = 'after';
  userName: string;

  constructor(private service: UserService, public router: Router) {
  }

  ngOnInit() {
  }

  submit() {
    let newUser = new User(this.firstName, this.lastName, this.userName, this.admin);
    this.service.register(newUser);
    this.router.navigate(['/signin']);
  }
}
