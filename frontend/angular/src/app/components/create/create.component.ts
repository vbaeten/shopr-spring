import {Component} from '@angular/core';
import {Router} from "@angular/router";

export interface Type {
  value: string;
  viewValue: string;
}


@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent {
  constructor(public router: Router){}
  selectedValue: string;

types: Type[] = [
  {value: 'lp', viewValue: 'LP'},
  {value: 'game', viewValue: 'Game'},
  {value: 'bookfiction', viewValue: 'Fiction Book'},
  {value: 'booknonfiction', viewValue: 'Non-fiction Book'}
];

  pickArticle(){
    let adres:string = this.selectedValue;
    switch(adres) {
      case "lp":
        this.router.navigate(['/createlp'])
            break;
      case "game":
        this.router.navigate(['/creategame'])
            break;
      case "bookfiction":
        this.router.navigate(['/createbookfiction'])
            break;
      case "booknonfiction":
        this.router.navigate(['/createbooknonfiction'])
    }
  }
}
