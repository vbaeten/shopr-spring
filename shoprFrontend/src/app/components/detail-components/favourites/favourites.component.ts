import {Component, Input, OnInit} from '@angular/core';
import {UserService} from "../../../services/user.service";

@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrls: ['./favourites.component.css']
})
export class FavouritesComponent implements OnInit {


  @Input() item
  user

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.user = this.userService.getCurrentUser()
    console.log(this.user)
  }


  addToFavourites() {
    this.user.favourites= new Array()
    this.user.favourites.push(this.item)
    this.userService.registerUser(this.user).subscribe(data=>this.user=data)

  }

}
