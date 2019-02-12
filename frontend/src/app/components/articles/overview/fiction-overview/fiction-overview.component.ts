import {Component, OnInit} from '@angular/core';
import {Fiction} from '../../../../models/fiction';
import {FictionService} from '../../../../services/fiction.service';
import {ArticleService} from '../../../../services/article.service';

@Component({
  selector: 'app-fiction-overview',
  templateUrl: './fiction-overview.component.html',
  styleUrls: ['./fiction-overview.component.css']
})
export class FictionOverviewComponent implements OnInit {

  fictionBooks: Fiction[] = [];
  dataSource;
  displayedColumns: string[] = ['id', 'title', 'price', 'delete'];

  constructor(private fictionService: FictionService, private articleService: ArticleService) {
  }

  ngOnInit() {
    this.refresh();
  }

  deleteArticle(id: number): void {
    this.articleService.deleteArticleById(id).subscribe(date => this.refresh());
  }

  refresh() {
    this.fictionService.getFictionBooks().subscribe(data => {
      this.fictionBooks = data;
      this.dataSource = this.fictionBooks;
    });
  }
}
