import { Injectable } from '@angular/core';
import {User} from "../models/user";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Router} from "@angular/router";
import {NavBarService} from "./nav-bar.service";


@Injectable()

export class UserService {

  private classUrl: string = environment.baseApiUrl+'/users';
  key:string='1'



  constructor(private http: HttpClient,private router:Router,private navBarService:NavBarService) { }


  public registerUser(user:User):Observable<User>{
     return this.http.post<User>(this.classUrl,user)

  }

  getUsers():Observable<User[]>{
    let x = this.http.get<User[]>(this.classUrl);
    return x;
  }

  loginUser(user:User){
    this.router.navigate(['/itemsOverview'])
    localStorage.setItem(this.key,JSON.stringify(user))
    this.navBarService.updateNavAfterAuth()
    this.navBarService.updateLoginStatus(true)
  }


  getCurrentUser(): User{

   return Object.assign(new User(),JSON.parse(localStorage.getItem(this.key)))
  }






}
