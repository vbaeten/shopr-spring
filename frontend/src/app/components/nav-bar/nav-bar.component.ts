import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {User} from "../../models/user";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  currentUser: User;


  constructor(private userService: UserService) {
  }

  ngOnInit() {
    // this.currentUser = this.userService.getCurrentUser();
    this.userService.getEmitter().subscribe(user => {
      this.currentUser = user;
      console.log("Component is notified of successful login!");
    });
  }


  logout(){
    this.userService.logout(this.currentUser);
  }
  //
  // get loggedIn(): boolean {
  //   return this.user.isLoggedIn;
  // }


}
