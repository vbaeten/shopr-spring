import { Component, OnInit } from '@angular/core';
import {UserService} from "../../../services/user.service";
import {DataService} from "../../../services/data.service";
import {ItemsService} from "../../../services/items.service";
import {Router} from "@angular/router";
import {Item} from "../../../models/item";

@Component({
  selector: 'app-favourites-page',
  templateUrl: './favourites-page.component.html',
  styleUrls: ['./favourites-page.component.css']
})
export class FavouritesPageComponent implements OnInit {

  favourites=[]
  user
  detailItem:Item
  detailLink
  displayedColumns: string[] = ['no', 'Title', 'type', 'price', 'details']


  constructor(private userService:UserService,private dataService:DataService,private itemService:ItemsService,private router:Router) { }

  ngOnInit() {
    this.user= this.userService.getCurrentUser()
    this.userService=this.user.favourites
  }



  toDetailPage(toPassId) {
    this.dataService.changeId(toPassId)
    this.itemService.getItemById(toPassId).subscribe((data) => {
      this.detailItem = data
      console.log(this.detailItem)
      this.defineRouterLink(this.detailItem)
      this.navigate()
    })
  }



  navigate() {
    this.router.navigate([this.detailLink])
  }

  defineRouterLink(item: Item) {

    if (item.type === "Game") {
      this.detailLink = "/gameDetails"
    }
    else if (item.type === "fiction book") {
      this.detailLink = "/fictionDetails"
    }
    else if (item.type === "non-fiction book") {
      this.detailLink = "/nonFictionDetails"
    }
    else if (item.type === "Lp") {
      this.detailLink = "/lpDetails"
    }

  }

}
