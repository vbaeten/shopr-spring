import {Injectable} from "@angular/core";
import {BehaviorSubject} from "rxjs";

const TOKEN_KEY = 'AuthToken';
const CURRENT_USER = 'CurrentUser';
const CURRENT_USER_ID = "CurrentUsersId";

@Injectable()
export class TokenStorage{

  currentUserSubject: BehaviorSubject<string> = new BehaviorSubject(sessionStorage.getItem(CURRENT_USER));

  constructor() {
  }

  signOut() {
    sessionStorage.clear();
    this.currentUserSubject.next(null);
  }

  public saveToken(token: string) {
    sessionStorage.removeItem(TOKEN_KEY);
    sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string {
    if (sessionStorage.getItem(TOKEN_KEY) === null) {
      return "";
    }
    return sessionStorage.getItem(TOKEN_KEY);
  }

  setCurrentUser(user: string) {
    sessionStorage.setItem(CURRENT_USER, user);
    this.currentUserSubject.next(user);
  }

  setCurrentUserId(id: string) {
    sessionStorage.setItem(CURRENT_USER_ID, id);
  }

  public getUserId(): number {
    return parseInt(sessionStorage.getItem(CURRENT_USER_ID));
  }

}
