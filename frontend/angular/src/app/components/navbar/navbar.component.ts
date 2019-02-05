import {Component, OnDestroy, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {User} from "../../domain/User";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, OnDestroy {

  currentUser: User;
  private userSubscription: Subscription;

  constructor(public userService: UserService) {
  }

  ngOnInit() {
    this.currentUser = this.userService.getCurrentUser();

    this.userSubscription = this.userService.userSubject.subscribe(() => this.currentUser = this.userService.getCurrentUser());
  }

  ngOnDestroy(): void {
    this.userSubscription.unsubscribe();
  }

  logout(): void {
    this.userService.logout();
  }

}
