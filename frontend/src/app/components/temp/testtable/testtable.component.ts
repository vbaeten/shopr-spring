import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import { MatPaginator, MatSort } from '@angular/material';
import { TesttableDataSource } from './testtable-datasource';
import {Subscription} from "rxjs";
import {LoginService} from "../../../services/login.service";
import {User} from "../../../models/user";

@Component({
  selector: 'app-testtable',
  templateUrl: './testtable.component.html',
  styleUrls: ['./testtable.component.css']
})
export class TesttableComponent implements OnInit, OnDestroy {

  currentUser: User = new User();
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

  ngOnDestroy(): void {
    this.userSubscription.unsubscribe();
  }

}
