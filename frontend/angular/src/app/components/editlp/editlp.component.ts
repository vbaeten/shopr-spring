import {Component, OnInit} from '@angular/core';
import {LpService} from "../../services/lp.service";
import {ArticleService} from "../../services/article.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Lp} from "../../domain/lp";
import {MatSnackBar} from "@angular/material";

@Component({
  selector: 'app-editlp',
  templateUrl: './editlp.component.html',
  styleUrls: ['./editlp.component.css']
})
export class EditlpComponent implements OnInit {
  lpGenres: string[];
  lp: Lp;

  constructor(private snackBar: MatSnackBar, private lpservice: LpService, private articleservice: ArticleService, public router: Router, private route: ActivatedRoute) {
  }

  viewSnackBar() {
    let message = 'Your lp has been successfully updated in Shopr.';
    let action = '';
    this.articleservice.getSnackBar(message, action)
  }

  ngOnInit() {
    this.lpservice.getLpGenres().subscribe(lpGenres => this.lpGenres = lpGenres)
    this.route.params.subscribe((params) => {
      this.articleservice.getArticleById(params['articleId']).subscribe(data => this.lp = data)
    })
  }

  edit() {
    this.lpservice.updateLp(this.lp).subscribe(
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
