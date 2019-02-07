import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  private userName: string;

  constructor(private userService: UserService, public router: Router) {
  }

  login() {
    this.userService.login(this.userName);
    this.router.navigate(['/articles']);
  }
  ngOnInit() {
  }

}
