import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {User} from '../models/user';
import {ApiService} from './api.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(
    private apiService: ApiService) {
  }

  getUsers(): Observable<User[]> {
    return this.apiService.doGet('/user/list');
  }

  getUser(id: number): Observable<User> {
    return this.apiService.doGet('/user/' + id);
  }

  registerUser(user: User): Observable<User> {
    return this.apiService.doPost('/user/register', user);
  }

  deleteUser(id: number): Observable<User> {
    return this.apiService.doDelete('/user/delete/' + id);
  }
}
