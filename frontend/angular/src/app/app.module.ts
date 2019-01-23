import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ArticlesOverviewComponent } from './components/articles-overview/articles-overview.component';
import {ArticleService} from "./services/article.service";
import {HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { NavbarComponent } from './components/navbar/navbar.component';
import {MatButton, MatButtonModule, MatToolbarModule} from "@angular/material";


@NgModule({
  declarations: [
    AppComponent,
    ArticlesOverviewComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    AppRoutingModule
  ],
  providers: [ArticleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
