import {Component, OnInit, ViewChild} from '@angular/core';
import {Lp} from '../../../../models/lp';
import {LpService} from '../../../../services/lp.service';
import {ArticleService} from "../../../../services/article.service";
import {MatTable} from "@angular/material";

@Component({
  selector: 'app-lp-overview',
  templateUrl: './lp-overview.component.html',
  styleUrls: ['./lp-overview.component.css']
})
export class LpOverviewComponent implements OnInit {

  lps: Lp[] = [];

  displayedColumns: string[] = ['id', 'title', 'price', 'delete'];
  dataSource;

  @ViewChild(MatTable) table: MatTable<any>;

  constructor(private lpService: LpService, private articleService: ArticleService) {
  }

  ngOnInit() {
    this.refresh();
  }

  deleteArticle(id: number): void {
    this.articleService.deleteArticleById(id).subscribe(data => this.refresh());
    this.table.renderRows();
  }

  refresh() {
    this.lpService.getLps().subscribe(data => {
      this.lps = data;
      this.dataSource = this.lps;
    });
  }
}
