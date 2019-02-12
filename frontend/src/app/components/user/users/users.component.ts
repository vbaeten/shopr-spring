import {ChangeDetectorRef, Component, Input, OnInit} from '@angular/core';
import {UserService} from '../../../services/user.service';
import {User} from '../../../models/user';

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
    this.refresh();
  }

  deleteUserById(id: number): void {
    this.userService.deleteUserById(id).subscribe( data => this.refresh());
  }

  refresh() {
    this.userService.getUsers().subscribe(data => {
      this.users = data;
      this.dataSource = this.users;
    });
  }
}
