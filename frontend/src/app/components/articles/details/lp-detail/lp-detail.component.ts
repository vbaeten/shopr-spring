import {Component, OnInit} from '@angular/core';
import {Lp} from '../../../../models/lp';
import {LpService} from '../../../../services/lp.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-lp-detail',
  templateUrl: './lp-detail.component.html',
  styleUrls: ['./lp-detail.component.css']
})
export class LpDetailComponent implements OnInit {

  lp: Lp;
  id: number;

  constructor(private lpService: LpService,
              private route: ActivatedRoute,
  ) {
  }

  ngOnInit() {
    this.getLp();
  }

  getLp() {
    this.route.params.subscribe(params => this.id = params['id']);
    this.lpService.getLp(this.id).subscribe(lp => this.lp = lp);
  }

}
