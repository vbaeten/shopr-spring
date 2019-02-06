import {Injectable} from "@angular/core";
import {Subject} from "rxjs";

const TOKEN_KEY = 'AuthToken';
const CURRENT_USER = 'CurrentUser';

@Injectable()
export class TokenStorage {

  currentUserSubject = new Subject();

  constructor() {}

  signOut() {
    sessionStorage.clear();
    this.currentUserSubject.next();
  }

  public saveToken(token: string) {
    sessionStorage.removeItem(TOKEN_KEY);
    sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string {
    if(sessionStorage.getItem(TOKEN_KEY) === null){
      return "";
    }
    return sessionStorage.getItem(TOKEN_KEY);
  }

  setCurrentUser(user){
    sessionStorage.setItem(CURRENT_USER, user);
    this.currentUserSubject.next(user);
  }
}
