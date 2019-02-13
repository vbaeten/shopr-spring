import {Component, Input, OnInit} from '@angular/core';
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
export class UserDetailComponent implements OnInit {

  id: number;
  currentUser;

  constructor(private userService: UserService,
              private route: ActivatedRoute,
              private loginService: LoginService) {
  }

  ngOnInit() {
    this.getUser();
    this.loginService.getCurrentUser().then(user => this.currentUser = user);
  }

  getUser() {
    this.route.params.subscribe(params => this.id = params['id']);
    this.userService.getUser(this.id).subscribe(user => this.currentUser = user);
  }
}
