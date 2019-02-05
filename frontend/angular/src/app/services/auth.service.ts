import {Injectable} from '@angular/core';
import {TokenStorage} from "./token.storage";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {BehaviorSubject, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private _authenticated: BehaviorSubject<boolean> = new BehaviorSubject(false);
  authenticatedObservable: Observable<boolean> = this._authenticated.asObservable();

  constructor(
    private tokenStorage: TokenStorage,
    private httpClient: HttpClient
  ) {
  }

  isAuthenticated(credentials, callback) {
    console.log(this.tokenStorage.getToken());
    let token;
    if (!this.tokenStorage.getToken() && credentials !== undefined) {
      token = 'Basic ' + btoa(credentials.username + ':' + credentials.password);
      this.tokenStorage.saveToken(token);
    } else {
      token = this.tokenStorage.getToken();
    }

    let headers = new HttpHeaders(credentials ? {
      Authorization: token,
    } : {});
    headers = headers.append("X-Requested-With", "XMLHttpRequest");
    this.httpClient.get('/api/user/currentuser', {headers: headers}).subscribe(response => {
      console.log("Response " + JSON.stringify(response));
      if (response['name']) {
        this._authenticated.next(true);
      } else {
        this._authenticated.next(false);
      }
      return callback && callback();
    });
  }

  logout() {
    this.httpClient.get("/api/logout").subscribe(() => {
      this.tokenStorage.signOut();
      this._authenticated.next(false)
    });
  }


}
