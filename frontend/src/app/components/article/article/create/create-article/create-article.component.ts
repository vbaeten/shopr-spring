import {Component, OnInit} from '@angular/core';
import {Article} from "../../../../../models/article";
import {Game} from "../../../../../models/game";
import {ArticleSevice} from "../../../../../services/article.sevice";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {GameService} from "../../../../../services/game.service";
import {GameGenre} from "../../../../../models/game-genre";

@Component({
  selector: 'app-create-article',
  templateUrl: './create-article.component.html',
  styleUrls: ['./create-article.component.css']
})
export class CreateArticleComponent implements OnInit {

  selectedValue: string;
  articleTypes: string[] = ["game","lp","fiction","nonFiction"];

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit() {
  }


}
