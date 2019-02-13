import {Component, OnInit} from '@angular/core';
import {Fiction} from '../../../../models/fiction';
import {FictionService} from '../../../../services/fiction.service';
import {ActivatedRoute} from "@angular/router";
import {OrderLine} from "../../../../models/order-line";
import {User} from "../../../../models/user";
import {ArticleService} from "../../../../services/article.service";
import {Article} from "../../../../models/article";

@Component({
  selector: 'app-fiction-detail',
  templateUrl: './fiction-detail.component.html',
  styleUrls: ['./fiction-detail.component.css']
})
export class FictionDetailComponent implements OnInit {

  fiction: Fiction;
  article: Article;

  id: number;
  orderLine: OrderLine;
  currentUser: User;

  constructor(private fictionService: FictionService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.getFiction();
    this.article = new Article();
    this.article.id = this.fiction.id;
  }

  getFiction() {
    this.route.params.subscribe(params => this.id = params['id']);
    this.fictionService.getFiction(this.id).subscribe(fiction => this.fiction = fiction);
  }
}
