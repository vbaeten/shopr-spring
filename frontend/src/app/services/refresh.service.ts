import { Injectable } from '@angular/core';
import {UserService} from "./user.service";
import {User} from "../models/user";
import {ArticleService} from "./article.service";

@Injectable({
  providedIn: 'root'
})
export class RefreshService {

  users: User [];
  dataSource;

  constructor(private userService: UserService,
              private articleService: ArticleService) { }

  getUsers() {
    this.userService.getUsers().subscribe(data => {
      this.users = data;
      this.dataSource = this.users;
    });



  }
}
