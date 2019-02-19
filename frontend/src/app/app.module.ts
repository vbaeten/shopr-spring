import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {RegisterComponent} from './components/user/register/register.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  MatButtonModule,
  MatCardModule,
  MatCheckboxModule,
  MatFormFieldModule,
  MatIconModule,
  MatInputModule, MatListModule,
  MatMenuModule,
  MatPaginatorModule,
  MatSelectModule,
  MatSnackBarModule,
  MatSortModule,
  MatTableModule,
  MatToolbarModule
} from '@angular/material';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {LoginComponent} from './components/user/login/login.component';
import {NavBarComponent} from './components/nav-bar/nav-bar.component';
import {CreateArticleComponent} from './components/article/article/create/create-article/create-article.component';
import {UserComponent} from './components/user/user/user.component';
import {UserDetailsComponent} from './components/user/user-details/user-details.component';
import {UserService} from "./services/user.service";
import {ArticleComponent} from './components/article/article/article.component';
import {FlexLayoutModule} from '@angular/flex-layout';
import {CreateGameComponent} from './components/article/article/create/create-game/create-game.component';
import {CreateLpComponent} from './components/article/article/create/create-lp/create-lp.component';
import {CreateFictionComponent} from './components/article/article/create/create-fiction/create-fiction.component';
import {CreateNonFictionComponent} from './components/article/article/create/create-non-fiction/create-non-fiction.component';
import {NgxMaskModule} from "ngx-mask";
import {FictionDetailsComponent} from './components/article/article/details/fiction-details/fiction-details.component';
import {NonFictionDetailsComponent} from './components/article/article/details/non-fiction-details/non-fiction-details.component';
import {GameDetailsComponent} from './components/article/article/details/game-details/game-details.component';
import {LpDetailsComponent} from './components/article/article/details/lp-details/lp-details.component';
import { GameOverviewComponent } from './components/article/article/overview/game-overview/game-overview.component';
import { LpOverviewComponent } from './components/article/article/overview/lp-overview/lp-overview.component';
import { FictionOverviewComponent } from './components/article/article/overview/fiction-overview/fiction-overview.component';
import { NonFictionOverviewComponent } from './components/article/article/overview/non-fiction-overview/non-fiction-overview.component';
import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component';

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
    FictionDetailsComponent,
    NonFictionDetailsComponent,
    GameDetailsComponent,
    LpDetailsComponent,
    GameOverviewComponent,
    LpOverviewComponent,
    FictionOverviewComponent,
    NonFictionOverviewComponent,
    ShoppingCartComponent,
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
    MatMenuModule,
    MatButtonModule,
    MatCheckboxModule,
    MatListModule,
    HttpClientModule,
    MatSelectModule,
    MatIconModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    FlexLayoutModule,
    NgxMaskModule.forRoot()
  ],
  providers: [HttpClient, UserService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
