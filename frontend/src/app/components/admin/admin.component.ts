import { Component, OnInit } from '@angular/core';
import { UserService} from "../../services/user.service";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  public users;

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  getUsers() {
    this.userService.getUsers().subscribe(
      data =>{this.users = data},
      err => console.error(err),
      () => console.log('users loaded')
    );
  }

}
