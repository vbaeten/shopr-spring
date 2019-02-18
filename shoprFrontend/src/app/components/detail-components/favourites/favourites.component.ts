import {Component, Input, OnInit} from '@angular/core';
import {UserService} from "../../../services/user.service";
import {Orderline} from "../../../models/Orderline";

@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrls: ['./favourites.component.css']
})
export class FavouritesComponent implements OnInit {


  @Input() item
  user
  favourites

  constructor(private userService: UserService) {
  }

  ngOnInit() {

    this.user = this.userService.getCurrentUser()
    console.log(this.user)
    this.favourites=   JSON.parse( sessionStorage.getItem('favourites'))
  }


  addToFavourites() {
    //TODO: check for duplicate favourite item in list

    if (this.favourites==null){
      this.favourites=new Array()
    }
    this.favourites.push(this.item)
    this.user.favourites=this.favourites
    sessionStorage.setItem('favourites',JSON.stringify( this.favourites))
    console.log(this.favourites)
    console.log(this.user.favourites)
    this.userService.registerUser(this.user).subscribe(data=>this.user=data)
  }

}
