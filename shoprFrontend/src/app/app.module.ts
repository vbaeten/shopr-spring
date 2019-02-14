import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddGameComponent } from './components/add-game/add-game.component';
import {
  MatButtonModule, MatCardModule,
  MatCheckboxModule,
  MatFormFieldModule, MatGridListModule,
  MatIconModule, MatInputModule,
  MatMenuModule, MatSelectModule, MatSnackBarModule, MatSortModule, MatTableModule,
  MatToolbarModule
} from "@angular/material";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { LoginRegisterComponent } from './components/login-register/login-register.component';
import { FooterComponent } from './components/footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { IndexComponent } from './components/index/index.component';
import { SearchComponent } from './components/search/search.component';
import { AddItemsComponent } from './components/add-items/add-items.component';
import { RegisterFormComponent } from './components/register-form/register-form.component';
import { LoginFormComponent } from './components/login-form/login-form.component';
import {HttpClientModule} from "@angular/common/http";
import {UserService} from "./services/user.service";
import { AddLpComponent } from './components/add-lp/add-lp.component';
import { AddFictionComponent } from './components/add-fiction/add-fiction.component';
import { AddNonFictionComponent } from './components/add-non-fiction/add-non-fiction.component';
import {GameService} from "./services/game.service";
import {LpService} from "./services/lp.service";
import {FictionService} from "./services/fiction.service";
import {NonFictionService} from "./services/non-fiction.service";
import { GamesOverviewComponent } from './components/overview/games-overview/games-overview.component';
import { LpsOverviewComponent } from './components/overview/lps-overview/lps-overview.component';
import { BooksOverviewComponent } from './components/overview/books-overview/books-overview.component';
import { FictionsOverviewComponent } from './components/overview/fictions-overview/fictions-overview.component';
import { NonFictionsOverviewComponent } from './components/overview/non-fictions-overview/non-fictions-overview.component';
import { AllItemsOverviewComponent } from './components/overview/all-items-overview/all-items-overview.component';
import { GamesDetailComponent } from './components/detail-components/games-detail/games-detail.component';
import {DataService} from "./services/data.service";
import { LpsDetailComponent } from './components/detail-components/lps-detail/lps-detail.component';
import { FictionsDetailComponent } from './components/detail-components/fictions-detail/fictions-detail.component';
import { NonFictionsDetailComponent } from './components/detail-components/non-fictions-detail/non-fictions-detail.component';
import { HeaderComponent } from './components/header/header.component';
import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component';
import {OrderLineService} from "./services/order-line.service";
import { DynamicNavBarComponent } from './components/navbar/dynamic-nav-bar/dynamic-nav-bar.component';
import {NavBarService} from "./services/nav-bar.service";
import { ThankYouComponent } from './components/index/thank-you/thank-you.component';
import {OrderService} from "./services/order.service";
import { EditGamesComponent } from './components/edit components/edit-games/edit-games.component';
import { EditLpsComponent } from './components/edit components/edit-lps/edit-lps.component';
import { EditFictionComponent } from './components/edit components/edit-fiction/edit-fiction.component';
import { EditNonFictionComponent } from './components/edit components/edit-non-fiction/edit-non-fiction.component';
import {ItemsService} from "./services/items.service";

@NgModule({
  declarations: [
    AppComponent,
    AddGameComponent,
    LoginRegisterComponent,
    FooterComponent,
    IndexComponent,
    SearchComponent,
    AddItemsComponent,
    RegisterFormComponent,
    LoginFormComponent,
    AddLpComponent,
    AddFictionComponent,
    AddNonFictionComponent,
    GamesOverviewComponent,
    LpsOverviewComponent,
    BooksOverviewComponent,
    FictionsOverviewComponent,
    NonFictionsOverviewComponent,
    AllItemsOverviewComponent,
    GamesDetailComponent,
    LpsDetailComponent,
    FictionsDetailComponent,
    NonFictionsDetailComponent,
    HeaderComponent,
    ShoppingCartComponent,
    DynamicNavBarComponent,
    ThankYouComponent,
    EditGamesComponent,
    EditLpsComponent,
    EditFictionComponent,
    EditNonFictionComponent
  ],

  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    MatToolbarModule,
    MatButtonModule,
    MatCheckboxModule,
    MatMenuModule,
    MatIconModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatSelectModule,
    HttpClientModule,
    MatGridListModule,
    MatTableModule,
    MatSortModule,
    MatCardModule,
    MatSnackBarModule
  ],

  providers: [
    UserService,
    GameService,
    LpService,
    FictionService,
    NonFictionService,
    DataService,
    OrderLineService,
    NavBarService,
    OrderService,
    ItemsService
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
