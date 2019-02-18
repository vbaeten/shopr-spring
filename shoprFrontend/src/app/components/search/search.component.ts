import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {Item} from "../../models/item";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  currentUser
  favourites:Item[]=[]

  constructor(private userService:UserService) { }

  ngOnInit() {
    this.currentUser=this.userService.getCurrentUser()
    this.favourites=   Object.assign(new Array<Item>(),JSON.parse( sessionStorage.getItem('favourites')))

    console.log( this.favourites[0])
  }



}
