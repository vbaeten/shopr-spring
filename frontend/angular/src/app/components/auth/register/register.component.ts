import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../services/auth.service";
import {UserService} from "../../../services/user.service";
import {Router} from "@angular/router";
import {User} from "../../../models/users.model";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = <User>{};

  constructor(private auth: AuthService, private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  register() {
    this.userService.create(this.user).subscribe(
      data => {
        console.log("Registration successful", true);
        this.router.navigate(['/login']);
      }
    )
  }

}
