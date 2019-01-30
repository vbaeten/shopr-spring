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

  create(user: User) {
    return this.http.post('/api/users', user);
  }

  delete(id: number) {
    return this.http.delete('/api/users/' + id);
  }

}
