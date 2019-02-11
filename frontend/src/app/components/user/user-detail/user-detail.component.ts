import {Component, Input, OnInit} from '@angular/core';
import {UserService} from '../../../services/user.service';
import {User} from '../../../models/user';
import {ActivatedRoute, Params} from '@angular/router';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

  user: User = new User();
  id: number;

  constructor(private userService: UserService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.getUser();
  }

  getUser() {
    this.route.params.subscribe(params => this.id = params['id']);
    this.userService.getUser(this.id).subscribe(user => this.user = user);
  }
}
