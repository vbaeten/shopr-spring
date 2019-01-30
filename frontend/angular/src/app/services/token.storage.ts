import {Injectable} from "@angular/core";

const TOKEN_KEY = 'AuthToken';

@Injectable()
export class TokenStorage {

  constructor() {}

  signOut() {
    sessionStorage.removeItem(TOKEN_KEY);
    sessionStorage.clear();
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

}
