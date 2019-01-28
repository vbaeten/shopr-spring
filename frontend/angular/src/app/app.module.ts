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
  MatOptionModule,
  MatPaginatorModule,
  MatSelectModule,
  MatSortModule,
  MatTableModule,
  MatToolbarModule
} from "@angular/material";
import {TableArticlesComponent} from "./components/table-articles/table-articles.component";
import {FooterComponent} from './components/footer/footer.component';
import {HomeComponent} from './components/home/home.component';
import {CreateComponent} from './components/create/create.component';
import {FormsModule} from "@angular/forms";
import {CreatelpComponent} from './components/createlp/createlp.component';
import {CreategameComponent} from './components/creategame/creategame.component';
import {CreatebookfictionComponent} from './components/createbookfiction/createbookfiction.component';
import {CreatebooknonfictionComponent} from './components/createbooknonfiction/createbooknonfiction.component';


@NgModule({
  declarations: [
    AppComponent,
    ArticlesOverviewComponent,
    NavbarComponent,
    TableArticlesComponent,
    FooterComponent,
    HomeComponent,
    CreateComponent,
    CreatelpComponent,
    CreategameComponent,
    CreatebookfictionComponent,
    CreatebooknonfictionComponent
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
    MatOptionModule,
    MatSelectModule,
    FormsModule

  ],

  providers: [ArticleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
