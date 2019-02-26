import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-create-article',
  templateUrl: './create-article.component.html',
  styleUrls: ['./create-article.component.css']
})
export class CreateArticleComponent implements OnInit {

  selectedValue: string;
  articleTypes: string[] = ["Game", "Lp", "Fiction", "Non fiction"];

  constructor() {
  }

  ngOnInit() {
  }


}
