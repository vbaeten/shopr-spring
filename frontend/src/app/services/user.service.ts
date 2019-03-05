import {Injectable} from '@angular/core';
import {User} from "../models/user";
import {ApiService} from "./api.service";
import {MatSnackBar} from "@angular/material";
import {Observable, Subject} from "rxjs";
import {OrderLine} from "../models/orderLine";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  userIsLoggedIn: Subject<any> = new Subject<any>();


  constructor(private notification: MatSnackBar, private apiService: ApiService, private router: Router) {
  }



  public getUsers(): Observable<User[]> {
    return this.apiService.doGet("/user")
  }

  public deleteById(id: number) {
    return this.apiService.doDelete("/id")
  }

  public getUserByUserName(userName: string) {
    return this.apiService.doGet("/user/" + userName);
  }

  public getCurrentUser(): User {
    return JSON.parse(localStorage.getItem('currentUser'));
  }

  public setCurrentUser(user: User) {
    if (this.getCurrentUser() === null) {
      localStorage.setItem('currentUser', JSON.stringify(user));
    } else {
      this.notification.open("Already logged in" + JSON.stringify(this.getCurrentUser()))
    }
  }

  public registerUser(user: User) {
    this.apiService.doPost("/user", user).subscribe(response => {
        this.login(user);
        this.notification.open("You are registered", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "You are not registered, try again! 👎", {duration: 3000});
      });
  };

  login(user: User) {
    this.setCurrentUser(user);
    let cart: OrderLine[] = JSON.parse(localStorage.getItem('cart'));
    if (cart === null) {
      this.router.navigate(["/articles/"])
    } else {
      this.router.navigate(["/shoppingCart/"])
    }
    this.userIsLoggedIn.next(user);

    setTimeout(() => {
      this.notification.open("You are logged in", "👍", {duration: 3000});
    }, 3500)
  }

  public logout(user: User) {
    this.removeCurrentUserFromStorage();
    user = undefined;
    this.userIsLoggedIn.next(user);
    this.notification.open("You are logged out", "👍", {duration: 3000});
  }

  getEmitter(){
    return this.userIsLoggedIn;
  }

  private removeCurrentUserFromStorage() {
      localStorage.removeItem('currentUser');
  }

}
