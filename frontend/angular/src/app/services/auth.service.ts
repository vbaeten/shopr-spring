import {Injectable} from '@angular/core';
import {TokenStorage} from "./token.storage";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private _authenticated: Subject<boolean> = new Subject();
  // authenticatedObservable: Observable<boolean> = this._authenticated.asObservable();

  constructor(
    private tokenStorage: TokenStorage,
    private httpClient: HttpClient,
  ) {
  }

  isAuthenticated(credentials, callback) {
    let token;
    let headers = new HttpHeaders();

    if (!this.tokenStorage.getToken() && credentials !== undefined) {
      token = 'Basic ' + btoa(credentials.username + ':' + credentials.password);
      this.tokenStorage.saveToken(token);
    } else {
      token = this.tokenStorage.getToken();
    }
    headers = headers.set("Authorization", token);

    this.httpClient.get('/api/user/currentuser', {headers: headers}).subscribe(response => {
      console.log(response);
      if (response['name']) {
        this.tokenStorage.setCurrentUser(response['name']);
        this.tokenStorage.setCurrentUserId(response['id']);
        this._authenticated.next(true);
      } else {
        this._authenticated.next(false);
        return callback && callback();
      }
    });
  }

  logout() {
    this.httpClient.get("/api/logout").subscribe(() => {
      this.tokenStorage.signOut();
      this._authenticated.next(false)
    });
  }


}
