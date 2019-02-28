import {Component, OnInit} from '@angular/core';
import {UserService} from "../../../services/user.service";
import {User} from "../../../models/user";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  selectedUser: User;
  users: User[];

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.getAllUsers();
  }

  login() {
    this.userService.login(this.selectedUser)
  }

  getAllUsers() {
    this.userService.getUsers().subscribe(data => {
      this.users = data;
    })
  }

  getCurrentUserByUserName(userName: string){
    this.userService.getUserByUserName(userName).subscribe(currentUser => {
      currentUser = this.selectedUser;
    })
  }

}
