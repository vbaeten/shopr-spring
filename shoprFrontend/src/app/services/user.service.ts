import { Injectable } from '@angular/core';
import {User} from "../models/user";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";


@Injectable()

export class UserService {

  private classUrl: string = environment.baseApiUrl+'/users';

  constructor(private http: HttpClient) { }


  public registerUser(user:User):Observable<User>{
     return this.http.post<User>(this.classUrl,user)

  }

  getUsers():Observable<User[]>{
    return this.http.get<User[]>(this.classUrl);
  }

}
