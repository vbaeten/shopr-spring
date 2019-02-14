import {Component, OnInit} from '@angular/core';
import {Fiction} from '../../../../models/fiction';
import {FictionService} from '../../../../services/fiction.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-fiction-detail',
  templateUrl: './fiction-detail.component.html',
  styleUrls: ['./fiction-detail.component.css']
})
export class FictionDetailComponent implements OnInit {

  fiction: Fiction;
  id: number;

  constructor(private fictionService: FictionService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.getFiction();
  }

  getFiction() {
    this.route.params.subscribe(params => this.id = params['id']);
    this.fictionService.getFiction(this.id).subscribe(fiction => this.fiction = fiction);
  }
}
