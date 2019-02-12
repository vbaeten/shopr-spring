import {Injectable} from '@angular/core';
import {User} from "../models/user";
import {ApiService} from "./api.service";
import {MatSnackBar} from "@angular/material";
import {BehaviorSubject, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(private notification: MatSnackBar, private apiService: ApiService) {
  }

  public registerUser(user: User) {
    this.apiService.doPost("/user", user).subscribe(response => {
        this.notification.open("You are registered", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "You are not registered, try again! 👎", {duration: 3000});
      })
  };

  public login(user: User) {
    this.apiService.doPut("/user", user).subscribe(response => {
        this.notification.open("You are logged in", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "You are not logged in, try again! 👎", {duration: 3000});
      })
  }

  public logout(user: User) {
    this.apiService.doPut("/user", user).subscribe(response => {
        this.notification.open("You are logged out", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "You are not logged out, try again! 👎", {duration: 3000});
      })
  }

  public getUsers(): Promise<User[]> {
    return this.apiService.doGet("/user")
      .toPromise()
      .catch(error => this.handleError(error))
  }

  private handleError(error: any): Promise<any> {
    return Promise.reject(error.message | error);
  }

  deleteById(id: number) {
    return this.apiService.doDelete("/id")

  }

}
