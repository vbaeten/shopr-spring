import {Component, OnInit} from '@angular/core';
import {BookfictionService} from "../../services/bookfiction.service";
import {ArticleService} from "../../services/article.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Bookfiction} from "../../domain/bookfiction";
import {MatSnackBar} from "@angular/material";

@Component({
  selector: 'app-editbookfiction',
  templateUrl: './editbookfiction.component.html',
  styleUrls: ['./editbookfiction.component.css']
})
export class EditbookfictionComponent implements OnInit {
  bookfictionGenres: string[];
  bookfiction: Bookfiction;

  constructor(private snackBar: MatSnackBar, private bookfictionservice: BookfictionService, private articleservice: ArticleService, public router: Router, private route: ActivatedRoute) {
  }

  viewSnackBar() {
    let message = 'Your fiction book has been successfully updated in Shopr.';
    let action = '';
    this.articleservice.getSnackBar(message, action)
  }
  ngOnInit() {
    this.bookfictionservice.getBookfictionGenres().subscribe(bookfictionGenres => this.bookfictionGenres = bookfictionGenres)
    this.route.params.subscribe((params) => {
      this.articleservice.getArticleById(params['articleId']).subscribe(data => this.bookfiction = data)
    })
  }

  edit() {
    this.bookfictionservice.updateBookfiction(this.bookfiction).subscribe(
      () => {
        this.viewSnackBar();
        this.router.navigate(['/articles'])
      },
      error1 => {
        alert("edit failed")
      },
    );
  }
}
