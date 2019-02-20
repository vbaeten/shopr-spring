import {Component, OnInit} from '@angular/core';
import {Game} from '../../../../models/game';
import {GameService} from '../../../../services/game.service';
import {ActivatedRoute} from '@angular/router';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-game-detail',
  templateUrl: './game-detail.component.html',
  styleUrls: ['./game-detail.component.css']
})
export class GameDetailComponent implements OnInit {

  private userSubscription: Subscription;
  game: Game;
  id: number;

  constructor(private gameService: GameService,
              private route: ActivatedRoute,
  ) {
  }

  ngOnInit() {
    this.getGame();
  }

  getGame() {
    this.route.params.subscribe(params => this.id = params['id']);
    this.gameService.getGame(this.id).subscribe(game => this.game = game);
  }
}
