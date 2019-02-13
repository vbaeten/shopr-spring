import {Component, OnInit} from '@angular/core';
import {NonFiction} from '../../../../models/non-fiction';
import {NonFictionService} from '../../../../services/non-fiction.service';
import {ActivatedRoute} from '@angular/router';
import {LoginService} from "../../../../services/login.service";
import {User} from "../../../../models/user";
import {OrderLine} from "../../../../models/order-line";
import {ShoppingCartService} from "../../../../services/shopping-cart.service";

@Component({
  selector: 'app-non-fiction-detail',
  templateUrl: './non-fiction-detail.component.html',
  styleUrls: ['./non-fiction-detail.component.css']
})
export class NonFictionDetailComponent implements OnInit {

  nonFiction: NonFiction;
  id: number;

  constructor(private nonFictionService: NonFictionService,
              private route: ActivatedRoute,
  ) {
  }

  ngOnInit() {
    this.getNonFiction();
  }

  getNonFiction() {
    this.route.params.subscribe(params => this.id = params['id']);
    this.nonFictionService.getNonFiction(this.id).subscribe(nonFiction => this.nonFiction = nonFiction);
  }
}
