import { Component, OnInit } from '@angular/core';
import {DataService} from "../../services/data.service";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  currentUser
  isLoggedIn

  constructor(private dataService: DataService, private userService: UserService) {
  }


  ngOnInit() {

    this.currentUser=this.userService.getCurrentUser()

    if(this.currentUser==null){
      this.isLoggedIn=false
    }else{
      this.isLoggedIn=true
    }

  }


  logOut(){
    this.userService.logOut()
  }

}
