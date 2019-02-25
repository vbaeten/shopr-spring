import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {User} from "../models/users.model";
import {TokenStorage} from "./token.storage";
import {Observable, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private tokenStorage: TokenStorage) {
  }

  getCurrentUser() {
    return this.tokenStorage.currentUserSubject;
  }

  getById() : number{
    return this.tokenStorage.getUserId();
  }

  registerUser(user: User): boolean {
    this.http.post("/api/user/register", user).subscribe(success => {
      alert("You are registered");
      return true;
    }, err => {
      alert("Something went wrong");
      return false;
    });
    return false;
  }

  isAdmin(): Observable<boolean> {
    let currentUserObservable: Subject<boolean> = new Subject<boolean>();
    this.http.get('/api/user/currentuser').subscribe(response => {
      let isAdmin = false;
      response['roles'].forEach(item => {
        if (item.authority === 'ADMIN') {
          isAdmin = true;
        }
      });
      currentUserObservable.next(isAdmin);
    });
    return currentUserObservable.asObservable();
  }

}
