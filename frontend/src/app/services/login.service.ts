import {Injectable} from '@angular/core';
import {User} from '../models/user';
import {Subject} from 'rxjs';
import {ApiService} from './api.service';
import {UserService} from './user.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public currentUser = 'user';
  private userKey = '1';
  userSubject = new Subject();

  constructor(private apiService: ApiService, private userService: UserService) {
  }

  public getCurrentUser(): Promise<User> {
    return new Promise((resolve, reject) => resolve(JSON.parse(localStorage.getItem(this.userKey))) );
  }

  getUser(): User {
    return Object.assign(new User(), JSON.parse(localStorage.getItem(this.currentUser)));
  }

  getUserId(): number {
    return Object.assign(new User(), JSON.parse(localStorage.getItem(this.userKey)));
  }

  login(user: User) {
   localStorage.setItem(this.userKey, JSON.stringify(user));
   this.userSubject.next();
  }

  logout() {
    localStorage.removeItem(this.userKey);
    this.userSubject.next();
  }
}
