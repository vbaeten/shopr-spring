import {Component, OnInit} from '@angular/core';
import {NonFiction} from '../../../../models/non-fiction';
import {NonFictionService} from '../../../../services/non-fiction.service';
import {ArticleService} from "../../../../services/article.service";

@Component({
  selector: 'app-non-fiction-overview',
  templateUrl: './non-fiction-overview.component.html',
  styleUrls: ['./non-fiction-overview.component.css']
})
export class NonFictionOverviewComponent implements OnInit {

  nonFictionBooks: NonFiction[] = [];
  dataSource;
  displayedColumns: string[] = ['id', 'title', 'price', 'delete'];


  constructor(private nonFictionService: NonFictionService, private articleService: ArticleService) {
  }

  ngOnInit() {
    this.nonFictionService.getNonFictionBooks().subscribe(data => {
      this.nonFictionBooks = data;
      this.dataSource = this.nonFictionBooks;
    });
  }

  deleteArticle(id: number): void {
    this.articleService.deleteArticleById(id).subscribe();
  }

}
