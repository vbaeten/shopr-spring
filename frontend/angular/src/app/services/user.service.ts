import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {User} from "../models/users.model";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getCurrentUser() {
    return this.http.get('/api/user/currentuser');
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

}
