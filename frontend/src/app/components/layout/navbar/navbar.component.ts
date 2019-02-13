import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {first} from 'rxjs/operators';
import {User} from '../../../models/user';
import {LoginService} from '../../../services/login.service';
import {Subscription} from "rxjs";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, OnDestroy {

  currentUser;
  private userSubscription: Subscription;

  constructor(private loginService: LoginService) {
  }

  ngOnInit() {
    this.getCurrentUser();
    this.userSubscription = this.loginService.userSubject.subscribe(() => this.getCurrentUser());
  }

  getCurrentUser() {
    this.loginService.getCurrentUser().then(user => this.currentUser = user);
  }

  logout() {
    this.loginService.logout();
  }

  ngOnDestroy(): void {
    this.userSubscription.unsubscribe();
  }
}
