import { Injectable } from '@angular/core';
import {BehaviorSubject, Subject} from "rxjs";
import {User} from "../models/user";
import {MatSnackBar} from "@angular/material";

@Injectable({
  providedIn: 'root'
})
export class DataService {


  private idSource = new BehaviorSubject<number>(0)
  detailId = this.idSource.asObservable()





  constructor( private snackBar:MatSnackBar) {
  }

  changeId(id:number){
    this.idSource.next(id)
  }


  openSnackBar(message: string,action:string) {
    this.snackBar.open(message,action,{duration:2000})
  }

}
