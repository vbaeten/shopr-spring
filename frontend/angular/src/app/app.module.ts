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
  MatCardModule,
  MatCheckboxModule,
  MatFormFieldModule,
  MatInputModule,
  MatOptionModule,
  MatPaginatorModule,
  MatRadioModule,
  MatSelectModule,
  MatSnackBarModule,
  MatSortModule,
  MatTableModule,
  MatToolbarModule
} from "@angular/material";
import {TableArticlesComponent} from "./components/table-articles/table-articles.component";
import {FooterComponent} from './components/footer/footer.component';
import {HomeComponent} from './components/home/home.component';
import {CreateComponent} from './components/create/create.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CreatelpComponent} from './components/createlp/createlp.component';
import {CreategameComponent} from './components/creategame/creategame.component';
import {CreatebookfictionComponent} from './components/createbookfiction/createbookfiction.component';
import {CreatebooknonfictionComponent} from './components/createbooknonfiction/createbooknonfiction.component';
import {DetailComponent} from './components/detail/detail.component';
import {RegisterComponent} from './components/register/register.component';
import {UserService} from "./services/user.service";
import {SigninComponent} from './components/signin/signin.component';
import {EditbookfictionComponent} from './components/editbookfiction/editbookfiction.component';
import {EditbooknonfictionComponent} from './components/editbooknonfiction/editbooknonfiction.component';
import {EditlpComponent} from './components/editlp/editlp.component';
import {EditgameComponent} from './components/editgame/editgame.component';
import {ShoppingcartComponent} from './components/shoppingcart/shoppingcart.component';
import {OrderService} from "./services/order.service";
import {OrderoverviewComponent} from './components/orderoverview/orderoverview.component';
import {NgxMaskModule} from "ngx-mask";
import {BookfictionService} from "./services/bookfiction.service";
import {BooknonfictionService} from "./services/booknonfiction.service";
import {GameService} from "./services/game.service";
import {LpService} from "./services/lp.service";
import {OrderlineService} from "./services/orderline.service";
import {ReactiveformComponent} from './components/reactiveform/reactiveform.component';
import {ReactiveformeditorComponent} from './components/reactiveformeditor/reactiveformeditor.component';


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
    CreatebooknonfictionComponent,
    DetailComponent,
    RegisterComponent,
    SigninComponent,
    EditbookfictionComponent,
    EditbooknonfictionComponent,
    EditlpComponent,
    EditgameComponent,
    ShoppingcartComponent,
    OrderoverviewComponent,
    ReactiveformComponent,
    ReactiveformeditorComponent,
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
    FormsModule,
    ReactiveFormsModule,
    MatCardModule,
    MatCheckboxModule,
    MatRadioModule,
    MatSnackBarModule,
    NgxMaskModule.forRoot()

  ],

  providers: [ArticleService, UserService, OrderService, BookfictionService, BooknonfictionService, GameService, LpService, OrderlineService],
  bootstrap: [AppComponent]
})
export class AppModule { }
