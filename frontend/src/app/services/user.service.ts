import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../models/user";
import {environment} from "../../environments/environment";
import {ApiService} from "./api.service";

@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(
    private apiService: ApiService) {
  }

  getUsers(): Observable<User[]>{
    return this.apiService.doGet('/user/list');
  }

  getUser(id: number): Observable<User> {
    return this.apiService.doGet<User>('/user/' + id);
  }

  registerUser(user:User): Observable<User> {
    return this.apiService.doPost('/user/register', user)
  }
}
