import {Component, OnInit} from '@angular/core';
import {UserService} from '../../../services/user.service';
import {User} from '../../../models/user';
import {assertNumber} from '@angular/core/src/render3/assert';
import {element} from 'protractor';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: User[] = [];
  dataSource;
  displayedColumns: string[] = ['id', 'firstName', 'name', 'delete'];

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.userService.getUsers().subscribe(data => {
      this.users = data;
      this.dataSource = this.users;
    });
  }

  deleteUser(user: User): void {
    this.userService.deleteUser(user).subscribe();
  }

  deleteUserById(id: number): void {
    this.userService.deleteUserById(id).subscribe();
  }
}
