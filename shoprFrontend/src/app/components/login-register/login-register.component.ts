import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {User} from "../../models/user";
import {NavBarService} from "../../services/nav-bar.service";

@Component({
  selector: 'app-login-register',
  templateUrl: './login-register.component.html',
  styleUrls: ['./login-register.component.css']
})
export class LoginRegisterComponent implements OnInit {



  isLoggedIn=false


  constructor( private navBarService: NavBarService) {
    this.navBarService.getLoginStatus().subscribe(status=>this.isLoggedIn=status)
  }

  ngOnInit() {
  }




}
