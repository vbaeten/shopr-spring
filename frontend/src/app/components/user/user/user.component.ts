import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";

import {User} from "../../../models/user";
import {UserService} from "../../../services/user.service";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit, AfterViewInit {

  users = new MatTableDataSource<User>();
  displayedColumns: string[] = ['userId', 'name', 'firstName'];
  selectedUser: User;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private router: Router, private userService: UserService) {

  }


  ngOnInit() {
    this.getAllUsers()
  };

  ngAfterViewInit(): void {
    this.users.sort = this.sort;
    this.users.paginator = this.paginator;
  }

  getAllUsers(){
    this.userService.getUsers()
      .subscribe( data => {
        this.users.data = data as User[];
      });
  }

  deleteUser(user: User): void {
    this.userService.deleteById(user.id)
      .subscribe( data => {
        this.users.data = this.users.data.filter(u => u !== user);
      })
  };



  onSelect(user: User) {
    this.selectedUser = user;
  }

  applyFilter(filterValue: string) {
    this.users.filter = filterValue.trim().toLowerCase();

    if (this.users.paginator) {
      this.users.paginator.firstPage();
    }
  }

}
