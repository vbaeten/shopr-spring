import {Component, OnInit} from '@angular/core';
import {User} from "../../domain/user";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  currentUser: User;

  constructor(public userService: UserService) {
  }

  ngOnInit() {
    this.userService.getCurrentUser().then(user => this.currentUser = user);
    this.userService.userSubject.subscribe(sessionUser => {
      this.currentUser = sessionUser;
    });
  }

}
