import {Component, OnInit} from '@angular/core';
import {LpService} from "../../services/lp.service";
import {ArticleService} from "../../services/article.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Lp} from "../../domain/lp";

@Component({
  selector: 'app-editlp',
  templateUrl: './editlp.component.html',
  styleUrls: ['./editlp.component.css']
})
export class EditlpComponent implements OnInit {
  lpGenres: string[];
  lp: Lp;

  constructor(private lpservice: LpService, private articleservice: ArticleService, public router: Router, private route: ActivatedRoute) {
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
        this.router.navigate(['/articles'])
      },
      error1 => {
        alert("edit failed")
      },
    );
  }
}
