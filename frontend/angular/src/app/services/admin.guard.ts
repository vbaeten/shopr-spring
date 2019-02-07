import {Injectable} from '@angular/core';
import {CanActivate, Router} from '@angular/router';
import {UserService} from "./user.service";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {

  constructor(
    private authService: AuthService,
    private userService: UserService,
    private router: Router) {}

  canActivate(): boolean {
  //   this.userService.getCurrentUser().subscribe(response => {
  //     this.currentUser = response;
  //     if(this.currentUser !== undefined){
    return true;
  }
}
