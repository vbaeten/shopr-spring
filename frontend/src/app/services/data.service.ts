import {Injectable} from '@angular/core';
import {LpService} from './lp.service';
import {GameService} from './game.service';
import {UserService} from './user.service';
import {User} from '../models/user';
import {Lp} from '../models/lp';
import {Game} from '../models/game';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  dataSource;
  users: User [];
  lps: Lp [];
  games: Game[];

  constructor(private userService: UserService,
              private lpService: LpService,
              private gameSevice: GameService
  ) {
  }


  loadUsers() {
    this.userService.getUsers().subscribe(data => {
      this.users = data;
      this.dataSource = this.users;
    });
  }

  loadLps() {
    this.lpService.getLps().subscribe(data => {
      this.lps = data;
      this.dataSource = this.lps;
    });
  }

  loadGames() {
    this.gameSevice.getGames().subscribe(data => {
      this.games = data;
      this.dataSource = this.games;
    });
  }


}
