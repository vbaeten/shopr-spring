import {Component, OnInit} from '@angular/core';
import {ArticleService} from "../../services/article.service";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../services/user.service";
import {User} from "../../domain/User";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  article: any = {};
  articleId: number;
  currentUser: User;

  constructor(private articleService: ArticleService, private userService: UserService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.articleId = this.route.snapshot.params['articleId'];
    // this.route.params.subscribe(params => this.articleId = params['articleId']);
    this.articleService.getArticleById(this.articleId).subscribe(article => this.article = article);
    console.log("detail")
    this.userService.userSubject.subscribe(sessionUser => {
      console.log(sessionUser);
      this.currentUser = sessionUser;
    });
  }

  deleteArticleById() {
    this.articleService.deleteArticleById(this.articleId).subscribe();
    this.router.navigate(['/articles']);
  }

  goToEdit() {
    this.router.navigate(['/edit' + this.article.type, this.articleId])
  }

}
