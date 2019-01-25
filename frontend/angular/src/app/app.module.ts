import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ArticlesOverviewComponent} from './components/articles-overview/articles-overview.component';
import {ArticleService} from "./services/article.service";
import {HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {NavbarComponent} from './components/navbar/navbar.component';
import {
  MatButtonModule,
  MatFormFieldModule,
  MatInputModule,
  MatPaginatorModule,
  MatSortModule,
  MatTableModule,
  MatToolbarModule
} from "@angular/material";
import {TableArticlesComponent} from "./components/table-articles/table-articles.component";


@NgModule({
  declarations: [
    AppComponent,
    ArticlesOverviewComponent,
    NavbarComponent,
    TableArticlesComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    AppRoutingModule,
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatSortModule,
    MatInputModule,
  ],

  providers: [ArticleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
