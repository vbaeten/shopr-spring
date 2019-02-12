import {Component, Input, OnInit} from '@angular/core';
import {first} from 'rxjs/operators';
import {User} from '../../../models/user';
import {LoginService} from '../../../services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  currentUser;

  constructor(private loginService: LoginService) {


  }

  ngOnInit() {
    this.currentUser = this.loginService.getCurrentUser();
  }

  logout() {
    this.loginService.logout();
    this.currentUser.refresh();
  }
}
