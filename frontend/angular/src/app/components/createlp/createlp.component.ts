import {Component, OnInit} from '@angular/core';
import {LpService} from "../../services/lp.service";
import {Lp} from "../../domain/Lp";
import {Router} from "@angular/router";
import {ArticleService} from "../../services/article.service";

@Component({
  selector: 'app-createlp',
  templateUrl: './createlp.component.html',
  styleUrls: ['./createlp.component.css']
})
export class CreatelpComponent implements OnInit {
  title: string;
  price: number;
  artist: string;
  supplierId: string;
  lpGenre: string;
  lpGenres: string[];

  constructor(private service: LpService, private articleservice: ArticleService, public router: Router) {
  }

  ngOnInit() {
    this.service.getLpGenres().subscribe(lpGenres => this.lpGenres = lpGenres);
  }
  submit() {
    let newLp = new Lp(this.title, 'lp', this.price, this.supplierId, this.lpGenre, this.artist );
    this.service.createLp(newLp).subscribe(result => {
        this.articleservice.allArticles();
      },
      error1 => {
        alert("create failed")
      },);

    this.router.navigate(["/articles"])
  }
}
