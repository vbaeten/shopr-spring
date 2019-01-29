import {Component, Input, OnInit} from '@angular/core';
import {UserService} from "../../../services/user.service";
import {User} from "../../../models/user";

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

  user: Object;
  id: number = 10;
  name: string = "Van Gucht";
  firstName: string = "Ines";

  constructor(private userService: UserService) { }

  ngOnInit() {

  }

}
