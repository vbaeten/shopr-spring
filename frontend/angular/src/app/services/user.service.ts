import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {User} from "../models/users.model";
import {TokenStorage} from "./token.storage";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private tokenStorage:TokenStorage) { }

  getCurrentUser() {
    return this.tokenStorage.currentUserSubject;
  }

  getById(id: number) {
    return this.http.get(`/user/` + id);
  }

  delete(id: number) {
    return this.http.delete('/api/users/' + id);
  }

  registerUser(user: User): boolean {
    this.http.post("/api/user/register", user).subscribe(success => {
      alert("You are registered");
      return true;
    }, err => {
      alert("Something went wrong");
      return false;
    });
    return false;
  }

  isAdmin(): boolean {
     this.http.get('/api/user/currentuser').subscribe(response => {
        let roles = [];
        roles = response['authorities'];
        roles.forEach(role => {
          if (role.toString().substr("ADMIN")) {
            return true;
          }
        });
      });
     return false;
  }

}
