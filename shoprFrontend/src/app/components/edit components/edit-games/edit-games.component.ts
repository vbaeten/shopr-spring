import { Component, OnInit } from '@angular/core';
import {DataService} from "../../../services/data.service";
import {GameService} from "../../../services/game.service";
import {NgForm} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-edit-games',
  templateUrl: './edit-games.component.html',
  styleUrls: ['./edit-games.component.css']
})
export class EditGamesComponent implements OnInit {


  passedId:number
  game

  constructor(private dataService:DataService, private gameService:GameService, private router:Router) { }

  ngOnInit() {
    this.dataService.detailId.subscribe(id=>this.passedId=id)
    this.game= this.gameService.getGameById(this.passedId).subscribe(game=>this.game=game)
  }


  edit(form:NgForm){

    this.game.minAge = form.value.minAge
    this.game.price = form.value.price
    this.game.title = form.value.title
    this.game.publisher = form.value.publisher
    this.gameService.createGame(this.game)
      .subscribe(data => this.game = data)
    this.router.navigate(['/gamesOverview'])
    this.gameService.createGame(this.game)
  }

  showSnackBar(){
    let message= 'Succesfully edited your item'
    let action= ''
    this.dataService.openSnackBar(message,action)
  }
}
