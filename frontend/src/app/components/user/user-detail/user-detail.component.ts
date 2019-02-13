import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {UserService} from '../../../services/user.service';
import {User} from '../../../models/user';
import {ActivatedRoute, Params} from '@angular/router';
import {Subscription} from 'rxjs';
import {LoginService} from "../../../services/login.service";

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit, OnDestroy {

  currentUser;
  private userSubscription: Subscription;

  constructor(private userService: UserService,
              private route: ActivatedRoute,
              private loginService: LoginService) {
  }

  ngOnInit() {
    this.getCurrentUser();
    this.userSubscription = this.loginService.userSubject.subscribe(() => this.getCurrentUser());
  }

  getCurrentUser() {
    this.loginService.getCurrentUser().then(user => this.currentUser = user);
  }

  ngOnDestroy(): void {
    this.userSubscription.unsubscribe();
  }
}
