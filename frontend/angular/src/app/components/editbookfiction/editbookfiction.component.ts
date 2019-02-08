import {Component, OnInit} from '@angular/core';
import {BookfictionService} from "../../services/bookfiction.service";
import {ArticleService} from "../../services/article.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Bookfiction} from "../../domain/Bookfiction";

@Component({
  selector: 'app-editbookfiction',
  templateUrl: './editbookfiction.component.html',
  styleUrls: ['./editbookfiction.component.css']
})
export class EditbookfictionComponent implements OnInit {
  // price: number;
  // title: string;
  // author: string;
  // supplierId: string;
  // isbn: string;
  // numberOfPages: number;
  // bookfictionGenre: string;
  bookfictionGenres: string[];
  // summary: string;
  bookfiction: Bookfiction;

  constructor(private bookfictionservice: BookfictionService, private articleservice: ArticleService, public router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.bookfictionservice.getBookfictionGenres().subscribe(bookfictionGenres => this.bookfictionGenres = bookfictionGenres)
    this.route.params.subscribe((params) => {
      this.articleservice.getArticleById(params['articleId']).subscribe(data => this.bookfiction = data)
    })
  }

  edit() {
    // let newBookfiction = new Bookfiction(this.title, 'bookfiction', this.price, this.supplierId, this.author, this.isbn, this.numberOfPages, this.bookfictionGenre, this.summary);
    this.bookfictionservice.updateBookfiction(this.bookfiction).subscribe(
      () => {
        this.router.navigate(['/articles'])
      },
      error1 => {
        alert("edit failed")
      },
    );
  }
}
