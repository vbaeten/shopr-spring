import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './components/user/register/register.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  MatCardModule,
  MatCheckboxModule,
  MatFormFieldModule, MatIconModule,
  MatInputModule, MatPaginatorModule,MatSelectModule,
  MatSnackBarModule, MatSortModule, MatTableModule, MatToolbarModule
} from '@angular/material';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { LoginComponent } from './components/user/login/login.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { CreateArticleComponent } from './components/article/create-article/create-article.component';
import { UserComponent } from './components/user/user/user.component';
import { UserDetailsComponent } from './components/user/user-details/user-details.component';
import {UserService} from "./services/user.service";
import { ArticleComponent } from './components/article/article/article.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { CreateGameComponent } from './components/article/create-game/create-game.component';
import { CreateLpComponent } from './components/article/create-lp/create-lp.component';
import { CreateFictionComponent } from './components/article/create-fiction/create-fiction.component';
import { CreateNonFictionComponent } from './components/article/create-non-fiction/create-non-fiction.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    NavBarComponent,
    CreateArticleComponent,
    UserComponent,
    UserDetailsComponent,
    ArticleComponent,
    CreateGameComponent,
    CreateLpComponent,
    CreateFictionComponent,
    CreateNonFictionComponent,
  ],
  imports: [
    ReactiveFormsModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatCardModule,
    MatSnackBarModule,
    MatFormFieldModule,
    MatToolbarModule,
    MatCheckboxModule,
    HttpClientModule,
    MatSelectModule,
    MatIconModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    FlexLayoutModule
  ],
  providers: [HttpClient, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
