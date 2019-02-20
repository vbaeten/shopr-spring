import {Injectable} from '@angular/core';
import {Observable, Subject} from 'rxjs';
import {User} from '../models/user';
import {ApiService} from './api.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  userAddedSubject = new Subject<User>();

  constructor(
    private apiService: ApiService) {
  }

  getUsers(): Observable<User[]> {
    return this.apiService.doGet('/user/list');
  }

  getUser(id: number): Observable<User> {
    return this.apiService.doGet('/user/' + id);
  }

  registerUser(user: User) {
    this.apiService.doPost('/user/register', user).subscribe(data => {
      this.userAddedSubject.next(data);
    });
  }

  deleteUserById(id: number): Observable<User> {
    return this.apiService.doDelete('/user/delete/' + id);
  }

  updateUser(user: User): Observable<User> {
    return this.apiService.doPost('/user/register', user);
  }
}
