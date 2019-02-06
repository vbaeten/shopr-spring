import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Subject} from "rxjs";
import {User} from "../domain/User";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  userSubject = new Subject<User>();
  private userKey: string = 'user';

  constructor(private httpClient: HttpClient) {
  }

  register(user: User): void {
    this.httpClient.post<User>('/user/register', user).subscribe(userObject => {
      this.userSubject.next(userObject);
      sessionStorage.setItem(this.userKey, JSON.stringify(userObject));
    });

  }

  login(userName: string): void {
    this.httpClient.get<User>('/user/login/' + userName).subscribe(userObject => {
      sessionStorage.setItem(this.userKey, JSON.stringify(userObject));
      this.userSubject.next(userObject);
    });
  }

  logout(): void {
    sessionStorage.removeItem(this.userKey);
    this.userSubject.next();
  }

  getCurrentUser(): User {
    return JSON.parse(sessionStorage.getItem(this.userKey));
  }
}
