import {Injectable} from '@angular/core';
import {User} from "../models/user";
import {ApiService} from "./api.service";
import {MatSnackBar} from "@angular/material";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(private notification: MatSnackBar, private apiService: ApiService) {
  }

  public registerUser(user: User) {
    this.apiService.doPost("/user", user).subscribe(response => {
        this.setCurrentUser(user);
        this.notification.open("You are registered", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "You are not registered, try again! 👎", {duration: 3000});
      });
  };

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
    if (this.getCurrentUser().userName === undefined) {
      localStorage.setItem('currentUser', JSON.stringify(user));
      this.login(user);
    } else {
      this.notification.open("Already logged in" + JSON.stringify(this.getCurrentUser()))
    }
  }

  public login(user: User) {
    if (user.loggedin === false) {
      user.loggedin = true;
    }
    setTimeout(() => {
      this.notification.open("You are logged in", "👍", {duration: 3000});
    }, 3500)
  }

  public logout(user: User) {
    if (user.loggedin === true) {
      user.loggedin = false;
    }
    this.setCurrentUser(user)
  }

  public removeCurrentUser(user: User) {
    if (this.getCurrentUser().userName === undefined) {
      console.log("No user logged in")
    } else {
      localStorage.removeItem('currentUser');
    }
    this.logout(user);
  }

}
