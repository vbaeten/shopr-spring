import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor( private http:HttpClient) {
  }

  getUsers(): Observable<any>{
    return this.http.get('//localhost:8080/user/list');
  }

  getUser(id: number): Observable<Object> {
    return this.http.get('/user/' + id);
  }

  createUser(user: Object): Observable<Object> {
    return this.http.post($)
  }
}
