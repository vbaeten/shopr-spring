import { Component, OnInit } from '@angular/core';
import {UserService} from "../../../../../services/user.service";
import {User} from "../../../../../models/user";

@Component({
  selector: 'app-article-overview',
  templateUrl: './article-overview.component.html',
  styleUrls: ['./article-overview.component.css']
})
export class ArticleOverviewComponent implements OnInit {

  users: User[] = [];

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

}
