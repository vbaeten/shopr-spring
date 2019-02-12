import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {NavBarService} from "../../../services/nav-bar.service";
import {LoginRegisterComponent} from "../../login-register/login-register.component";
import {AllItemsOverviewComponent} from "../../overview/all-items-overview/all-items-overview.component";

@Component({
  selector: 'app-dynamic-nav-bar',
  templateUrl: './dynamic-nav-bar.component.html',
  styleUrls: ['./dynamic-nav-bar.component.css']
})
export class DynamicNavBarComponent implements OnInit {


  links:Array<{text:string,path:string}>
  isLoggedIn=false



  constructor(private router:Router, private navBarService:NavBarService) {
    this.router.config.unshift(
      {path:'login',component:LoginRegisterComponent},
            {path:'itemsOverview',component:AllItemsOverviewComponent}
    )
  }

  ngOnInit() {
    this.links=this.navBarService.getLinks()
    this.navBarService.getLoginStatus().subscribe(status=>this.isLoggedIn=status)
  }


  logOut(){

    this.navBarService.updateLoginStatus(false)
    this.router.navigate(['/itemsOverview'])
    localStorage.clear()
  }

}
