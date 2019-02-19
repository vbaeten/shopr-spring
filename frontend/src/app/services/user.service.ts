import {Injectable} from '@angular/core';
import {User} from "../models/user";
import {ApiService} from "./api.service";
import {MatSnackBar} from "@angular/material";
import {Observable} from "rxjs";
import {hasOwnProperty} from "tslint/lib/utils";

@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(private notification: MatSnackBar, private apiService: ApiService) {
  }


  //
  // public login(user: User) {
  //   this.apiService.doPut("/user", user).subscribe(response => {
  //
  //     },
  //     err => {
  //       this.notification.open("Something went wrong", "You are not logged in, try again! 👎", {duration: 3000});
  //     })
  // }
  //
  // public logout(user: User) {
  //   this.apiService.doPut("/user", user).subscribe(response => {
  //       this.notification.open("You are logged out", "👍", {duration: 3000});
  //     },
  //     err => {
  //       this.notification.open("Something went wrong", "You are not logged out, try again! 👎", {duration: 3000});
  //     })
  // }


  public getUserByUserName(userName: string) {
    return this.apiService.doGet("/user/" + userName);
  }

  public getUsers(): Observable<User[]> {
    return this.apiService.doGet("/user")
  }

  deleteById(id: number) {
    return this.apiService.doDelete("/id")
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

  public setCurrentUser(user: User) {
    let currentUser:User = this.getCurrentUser();
    if (currentUser.name === undefined) {
      localStorage.setItem('currentUser', JSON.stringify(user));
      this.login(user);
    } else {
      this.notification.open("Already logged in" + JSON.stringify(localStorage.getItem('currentUser')))
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
    localStorage.setItem('currentUser',JSON.stringify(new User()))
  }

  public getCurrentUser(): User {
    return JSON.parse(localStorage.getItem('currentUser'));
  }

  public removeCurrentUser(user: User) {
    if (localStorage.getItem('currentUser') === null) {
      console.log("No user logged in")
    } else {
      localStorage.removeItem('currentUser');
    }
    this.logout(user);
  }

}
