import {Injectable} from '@angular/core';
import {TokenStorage} from "./token.storage";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private _authenticated: boolean =false;

  constructor(
    private tokenStorage: TokenStorage,
    private httpClient: HttpClient,
    private router: Router,
    private http: HttpClient
  ) {
  }

  isAuthenticated(credentials, callback) {
    console.log(this.tokenStorage.getToken());
    if (!this.tokenStorage.getToken()) {
      let token;
      if (credentials !== undefined) {
        token = 'Basic ' + btoa(credentials.username + ':' + credentials.password);
        this.tokenStorage.saveToken(token);
      }

      const headers = new HttpHeaders(credentials ? {
        Authorization: token
      } : {});
      this.httpClient.get('/api/user/currentuser', {headers: headers}).subscribe(response => {
        if (response['name']) {
          this._authenticated = true;
        } else {
          this._authenticated = false;
        }
        return callback && callback();
      });
      return this.authenticated;
    }
    this._authenticated = true;
    return true;
  }

  logout() {
    localStorage.removeItem('currentUser');
    this._authenticated = false;
  }


  get authenticated(): boolean {
    return this._authenticated;
  }
}
