import { Injectable } from '@angular/core';
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class NavBarService {

  private links = new Array<{text:string,path:string}>()
  private isLoggedIn= new Subject<boolean>()
  currentUser

  constructor() {
    this.addItem({text:'Login',path:''})
    this.isLoggedIn.next(false)
  }


  getLinks(){
    return this.links;
  }

  getLoginStatus(){
    return this.isLoggedIn
  }

  updateLoginStatus(status:boolean){
    this.isLoggedIn.next(status)

    if(!status){
      this.clearAllItems()
      this.addItem({text:'login',path:''})
    }
  }

  updateNavAfterAuth():void{
    this.currentUser=JSON.parse(localStorage.getItem('1'))
    this.removeItem({text:'login'})
    this.addItem({text:'logged in as: '+this.currentUser.userName,path:'favouritesPage'})
  }

  addItem({text,path}){
    this.links.push({text:text,path:path})
  }


  removeItem({text}){
    this.links.forEach((link,index)=>{
      if(link.text===text){
        this.links.splice(index,1)
      }
    })
  }

  clearAllItems(){
    this.links.length=0;
  }


}
