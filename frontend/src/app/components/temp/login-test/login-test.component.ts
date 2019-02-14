import { Component, OnInit } from '@angular/core';
import {User} from '../../../models/user';
import {UserService} from '../../../services/user.service';
import {ActivatedRoute, Params} from '@angular/router';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-login-test',
  templateUrl: './login-test.component.html',
  styleUrls: ['./login-test.component.css']
})
export class LoginTestComponent implements OnInit {

  user: User = new User();

  constructor(private userService: UserService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getUser();
  }

  getUser() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.userService.getUser(id).subscribe(user => this.user = user);
  }
}
