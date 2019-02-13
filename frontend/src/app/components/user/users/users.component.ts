import {ChangeDetectorRef, Component, Input, OnInit, ViewChild} from '@angular/core';
import {UserService} from '../../../services/user.service';
import {User} from '../../../models/user';
import {MatSort, Sort} from '@angular/material';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: User[] = [];
  dataSource;
  displayedColumns: string[] = ['id', 'firstName', 'name', 'delete'];

  @ViewChild(MatSort) sort: MatSort;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.refresh();
  }

  deleteUserById(id: number): void {
    this.userService.deleteUserById(id).subscribe( data => this.refresh());
    this.dataSource.sort = this.sort;
  }

  refresh() {
    this.userService.getUsers().subscribe(data => {
      this.users = data;
      this.dataSource = this.users;
    });
  }

  // sortData(sort: Sort) {
  //
  // }
}
