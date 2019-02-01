import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {UserService} from "../../services/user.service";
import {User} from "../../models/users.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  private _isAuthenticatedUser: boolean;
  private _currentUser: User;

  constructor(private authService: AuthService, private userService: UserService, private router: Router) {
  }

  ngOnInit() {
    this.authService.authenticatedObservable.subscribe(data => {
      this._isAuthenticatedUser = data
    });
    console.log('currentUser is : ' + this._currentUser);
  }

  logout() {
    this.authService.logout();
    this.router.navigate(["/"]);
  }

  get isAuthenticatedUser(): boolean {
    return this._isAuthenticatedUser;
  }

}
