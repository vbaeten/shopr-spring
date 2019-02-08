import {Component, OnInit} from '@angular/core';
import {BooknonfictionService} from "../../services/booknonfiction.service";
import {ArticleService} from "../../services/article.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Booknonfiction} from "../../domain/Booknonfiction";

@Component({
  selector: 'app-editbooknonfiction',
  templateUrl: './editbooknonfiction.component.html',
  styleUrls: ['./editbooknonfiction.component.css']
})
export class EditbooknonfictionComponent implements OnInit {
  booknonfictionGenres: string[];
  booknonfiction: Booknonfiction;

  constructor(private booknonfictionservice: BooknonfictionService, private articleservice: ArticleService, public router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.booknonfictionservice.getBooknonfictionGenres().subscribe(booknonfictionGenres => this.booknonfictionGenres = booknonfictionGenres)
    this.route.params.subscribe((params) => {
      this.articleservice.getArticleById(params['articleId']).subscribe(data => this.booknonfiction = data)
    })
  }

  edit() {
    this.booknonfictionservice.updateBooknonfiction(this.booknonfiction).subscribe(
      () => {
        this.router.navigate(['/articles'])
      },
      error1 => {
        alert("edit failed")
      },
    );
  }
}
