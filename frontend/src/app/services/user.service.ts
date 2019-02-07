import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {User} from '../models/user';
import {ApiService} from './api.service';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
private classUrl: string = environment.apiUrl;

  constructor(
    private apiService: ApiService, private http: HttpClient) {
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

  createUser(user: User): Observable<User> {
    return this.http.post<User>(this.classUrl + '/user/register', user);
  }

  deleteUserById(id: number): Observable<User> {
    return this.apiService.doDelete('/user/delete/' + id);
  }

  deleteUser(user: User | number): Observable<User> {
    return this.apiService.doDelete('/user/delete');
  }
}
