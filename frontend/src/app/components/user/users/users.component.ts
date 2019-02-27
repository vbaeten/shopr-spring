import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {UserService} from '../../../services/user.service';
import {User} from '../../../models/user';
import {MatSort, MatTableDataSource} from '@angular/material';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit, OnDestroy {

  users: User[] = [];
  dataSource;
  displayedColumns: string[] = ['id', 'firstName', 'name', 'delete'];
  userAddedSubscription: Subscription;

  @ViewChild(MatSort) sort: MatSort;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.refresh();
    this.userAddedSubscription = this.userService.userAddedSubject.subscribe(user => {
      this.users.push(user);
      this.dataSource = new MatTableDataSource<User>(this.users);
    });
  }

  deleteUserById(id: number): void {
    this.userService.deleteUserById(id).subscribe( data => this.refresh());
    this.dataSource.sort = this.sort;
  }

  deleteUser(user: User): void {
    this.userService.deleteUser(user);
  }

  refresh() {
    this.userService.getUsers().subscribe(data => {
      this.users = data;
      this.dataSource = this.users;
    });
  }

  ngOnDestroy(): void {
    this.userAddedSubscription.unsubscribe();
  }

}
