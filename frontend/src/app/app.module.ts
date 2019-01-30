import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from "@angular/common/http";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/layout/header/header.component';
import { FooterComponent } from './components/layout/footer/footer.component';
import { NavbarComponent } from './components/layout/navbar/navbar.component';
import { UserService} from "./services/user.service";
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/user/register/register.component';
import { AppMaterialModule } from "./modules/app-material/app-material.module";
import { LoginComponent } from './components/user/login/login.component';
import { UsersComponent } from './components/user/users/users.component';
import { LpDetailComponent } from './components/articles/details/lp-detail/lp-detail.component';
import { GameDetailComponent } from './components/articles/details/game-detail/game-detail.component';
import { UserDetailComponent } from './components/user/user-detail/user-detail.component';
import { FictionDetailComponent } from './components/articles/details/fiction-detail/fiction-detail.component';
import { NonFictionDetailComponent } from './components/articles/details/non-fiction-detail/non-fiction-detail.component';
import { ArticleOverviewComponent } from './components/articles/overview/article/article-overview/article-overview.component';
import { ShopComponent } from './components/shop/shop/shop.component';
import { ShoppingCartComponent } from './components/order/shopping-cart/shopping-cart.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavbarComponent,
    HomeComponent,
    RegisterComponent,
    LoginComponent,
    UsersComponent,
    LpDetailComponent,
    GameDetailComponent,
    UserDetailComponent,
    FictionDetailComponent,
    NonFictionDetailComponent,
    ArticleOverviewComponent,
    ShopComponent,
    ShoppingCartComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    AppMaterialModule
  ],
  providers: [
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
