import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {TokenStorage} from "../../services/token.storage";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  currentUser: string;

  isLoggedIn: boolean = false;

  constructor(private tokenStorage: TokenStorage, private authService: AuthService, private userService: UserService, private router: Router) {
  }

  ngOnInit() {
    this.userService.getCurrentUser().subscribe(response => {
      console.log(response);
      this.currentUser = response;
      if(this.currentUser !== undefined){
        this.isLoggedIn = true;
      }else {
        this.isLoggedIn = false;
      }
    });
  }


  logout() {
    this.authService.logout();
    this.isLoggedIn = false;
    this.router.navigate(["/"]);
  }

}
