import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Subject} from "rxjs";
import {User} from "../domain/User";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  userSubject = new Subject();
  private userKey: string = 'user';

  constructor(private httpClient: HttpClient) {
  }

  register(user: User): void {
    this.httpClient.post<User>('/user/register', user).subscribe(data => sessionStorage.setItem(this.userKey, JSON.stringify(data)));
    this.userSubject.next();
  }

  login(userName: string): void {
    this.httpClient.get<User>('/user/login/' + userName).subscribe(data => sessionStorage.setItem(this.userKey, JSON.stringify(data)));
    this.userSubject.next();
  }

  logout(): void {
    sessionStorage.removeItem(this.userKey);
    this.userSubject.next();
  }

  getCurrentUser(): User {
    return JSON.parse(sessionStorage.getItem(this.userKey));
  }
}
