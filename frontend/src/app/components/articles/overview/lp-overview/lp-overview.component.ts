import { Component, OnInit } from '@angular/core';
import {Lp} from '../../../../models/lp';
import {LpService} from '../../../../services/lp.service';

@Component({
  selector: 'app-lp-overview',
  templateUrl: './lp-overview.component.html',
  styleUrls: ['./lp-overview.component.css']
})
export class LpOverviewComponent implements OnInit {

  lps: Lp[] = [];
  dataSource;
  displayedColumns: string[] = ['id', 'title', 'price'];

  constructor(private lpService: LpService) { }

  ngOnInit() {
    this.lpService.getLps().subscribe(data => {
      this.lps = data;
      this.dataSource = this.lps;
    });
  }
}
