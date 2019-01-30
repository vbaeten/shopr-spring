import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../models/user";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private classUrl: string = environment.apiUrl + '/user';
  private userUrl: string = environment.baseApiUrl + '/user';

  constructor( private http:HttpClient) {
  }

  getUsers(): Observable<User[]>{
    return this.http.get<User[]>(this.classUrl + "/list");
  }

  getUserz(): void {
    this.http.get<User[]>('/user/list')
  }

  getUser(id: number): Observable<User> {
    return this.http.get<User>('/user/' + id);
  }

  // createUser(user: User): Observable<User> {
  //   return this.http.post('user/register')
  // }
}
