import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject} from "rxjs";
import {User} from "../domain/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  userSubject: BehaviorSubject<User> = new BehaviorSubject<User>(null);
  private userKey: string = 'user';

  constructor(private httpClient: HttpClient) {
  }

  register(user: User): void {
    this.httpClient.post<User>('/user/register', user).subscribe(userObject => {
      // this.userSubject.next(userObject);
      // sessionStorage.setItem(this.userKey, JSON.stringify(userObject));
    });

  }

  login(userName: string): Promise<any> {
    return new Promise((resolve, reject) => {
      this.httpClient.post<User>('/user/login/', userName).subscribe(userObject => {
        sessionStorage.setItem(this.userKey, JSON.stringify(userObject));
        this.userSubject.next(userObject);
        resolve();
      }, error => reject(error))
    });
  }

  logout(): void {
    sessionStorage.removeItem(this.userKey);
    this.userSubject.next(null);
  }

  getCurrentUser(): Promise<User> {
    return new Promise((resolve, reject) => {
      resolve(JSON.parse(sessionStorage.getItem(this.userKey)));
    });
  }
}
