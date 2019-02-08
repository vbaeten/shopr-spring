import { Injectable } from '@angular/core';
import {User} from "../models/user";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable, Subject} from "rxjs";
import {Router} from "@angular/router";


@Injectable()

export class UserService {

  private classUrl: string = environment.baseApiUrl+'/users';
  key:string='1'
  updateHeader = new Subject()



  constructor(private http: HttpClient,private router:Router) { }


  public registerUser(user:User):Observable<User>{
     return this.http.post<User>(this.classUrl,user)

  }

  getUsers():Observable<User[]>{
    return this.http.get<User[]>(this.classUrl);
  }

  login(user:User){
    this.router.navigate(['/itemsOverview'])
    localStorage.setItem(this.key,JSON.stringify(user))
    this.updateHeader.next()
  }


  getCurrentUser(): User{

   return JSON.parse(localStorage.getItem(this.key))
  }


  logOut(){
    localStorage.clear()
    this.updateHeader.next()
  }

}
