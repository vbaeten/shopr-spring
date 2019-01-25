import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor( private http:HttpClient) {
  }

  getUsers() {
    return this.http.get('/users');
  }

  getUser(id: number) {
    return this.http.get('/users/' + id);
  }

  createUser(user) {

  }
}
