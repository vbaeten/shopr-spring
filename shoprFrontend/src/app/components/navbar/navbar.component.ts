import { Component, OnInit } from '@angular/core';
import {DataService} from "../../services/data.service";
import {User} from "../../models/user";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  currentUser: User


  constructor(private dataService:DataService) { }

  ngOnInit() {

    this.dataService.currentUser.subscribe(data=>this.currentUser=data)
  }

}
