import {Component, OnInit} from '@angular/core';
import {BooknonfictionService} from "../../services/booknonfiction.service";
import {ArticleService} from "../../services/article.service";
import {Router} from "@angular/router";
import {Booknonfiction} from "../../domain/booknonfiction";


@Component({
  selector: 'app-createbooknonfiction',
  templateUrl: './createbooknonfiction.component.html',
  styleUrls: ['./createbooknonfiction.component.css'],

})
export class CreatebooknonfictionComponent implements OnInit {
  price: number;
  title: string;
  author: string;
  supplierId: string;
  isbn: string;
  numberOfPages: number;
  booknonfictionGenre: string;
  booknonfictionGenres: string[];


  constructor(private service: BooknonfictionService, private articleservice: ArticleService, public router: Router) {

  }

  ngOnInit() {
    this.service.getBooknonfictionGenres().subscribe(booknonfictionGenres => this.booknonfictionGenres = booknonfictionGenres);
  }

  submit() {
    let newBooknonfiction = new Booknonfiction(this.title, 'booknonfiction', this.price, this.supplierId, this.author, this.isbn, this.numberOfPages, this.booknonfictionGenre);
    this.service.createBooknonfiction(newBooknonfiction).subscribe(
      result => {
        this.articleservice.allArticles();
      },
      error1 => {
        alert("create failed")
      },
    );
    this.router.navigate(['/articles'])
  }
}
