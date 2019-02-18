import {Component, OnInit} from '@angular/core';
import {BookfictionService} from "../../services/bookfiction.service";
import {Bookfiction} from "../../domain/bookfiction";
import {Router} from "@angular/router";
import {ArticleService} from "../../services/article.service";
import {MatSnackBar} from "@angular/material";


@Component({
  selector: 'app-createbookfiction',
  templateUrl: './createbookfiction.component.html',
  styleUrls: ['./createbookfiction.component.css']
})
export class CreatebookfictionComponent implements OnInit {
  price: number;
  title: string;
  author: string;
  supplierId: string;
  isbn: string;
  numberOfPages: number;
  bookfictionGenre: string;
  bookfictionGenres: string[];
  summary: string;

  constructor(private snackBar: MatSnackBar, private service: BookfictionService, private articleservice: ArticleService, public router: Router) {

  }

  viewSnackBar() {
    let message = 'Your fiction book had been successfully added to Shopr.';
    let action = '';
    this.articleservice.getSnackBar(message, action)
  }

  ngOnInit() {
    this.service.getBookfictionGenres().subscribe(bookfictionGenres => this.bookfictionGenres = bookfictionGenres);
  }

  submit() {
    let newBookfiction = new Bookfiction(this.title, 'bookfiction', this.price, this.supplierId, this.author, this.isbn, this.numberOfPages, this.bookfictionGenre, this.summary);
    this.service.createBookfiction(newBookfiction).subscribe(
      result => {
        this.articleservice.allArticles();
        this.viewSnackBar();
        this.router.navigate(['/articles'])
      },
      error1 => {
        alert("create failed")
      },
    );
  }

}
