import { Injectable } from '@angular/core';
import {BehaviorSubject, Subject} from "rxjs";
import {User} from "../models/user";

@Injectable({
  providedIn: 'root'
})
export class DataService {


  private idSource = new BehaviorSubject<number>(0)
  detailId = this.idSource.asObservable()





  constructor() {
  }

  changeId(id:number){
    this.idSource.next(id)
  }



}
