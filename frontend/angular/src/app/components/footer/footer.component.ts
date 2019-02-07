import {Component, OnInit} from '@angular/core';
import {User} from "../../domain/User";
import {Subscription} from "rxjs";
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  currentUser: User;
  private userSubscription: Subscription;

  constructor(public userService: UserService, public router: Router) {
  }

  ngOnInit() {
    this.userSubscription = this.userService.userSubject.subscribe(sessionUser => {
      this.currentUser = sessionUser;
    });
  }

}
