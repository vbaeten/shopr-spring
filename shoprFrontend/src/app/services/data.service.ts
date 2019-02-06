import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {User} from "../models/user";

@Injectable({
  providedIn: 'root'
})
export class DataService {


  private idSource = new BehaviorSubject<number>(0)
  detailId = this.idSource.asObservable()

  guest:User
  userSource = new BehaviorSubject<User>(this.guest)
  currentUser = this.userSource.asObservable()


  constructor() { }

  changeId(id:number){
    this.idSource.next(id)
  }

  changeUser(user:User){
    this.userSource.next(user)
  }

}
