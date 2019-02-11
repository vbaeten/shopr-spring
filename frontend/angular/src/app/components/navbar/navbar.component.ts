import {Component, OnDestroy, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {User} from "../../domain/user";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, OnDestroy {

  currentUser: User;
  private userSubscription: Subscription;

  constructor(public userService: UserService, public router: Router) {
  }

  ngOnInit() {
    this.userSubscription = this.userService.userSubject.subscribe(sessionUser => {
      this.currentUser = sessionUser;
    });
  }

  ngOnDestroy(): void {
    this.userSubscription.unsubscribe();
  }

  logout(): void {
    this.userService.logout();
    this.router.navigate(['/home']);
  }

}
