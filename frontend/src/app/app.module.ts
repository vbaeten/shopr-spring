import {BrowserModule} from '@angular/platform-browser';
import {Injector, NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {UserModule} from "./components/user/user.module";
import {SharedModule} from "./modules/shared-module/shared.module";
import {NavBarModule} from "./components/nav-bar/nav-bar.module";
import {ArticleDetailsModule} from "./components/article/article/details/article-details.module";
import {OverviewModule} from "./components/article/article/overview/overview.module";
import {CreateArticleModule} from "./components/article/article/create/create-article.module";
import {PageNotFoundModule} from "./components/page-not-found/page-not-found.module";
import {ShoppingCartModule} from "./components/shopping-cart/shopping-cart.module";
import {AppInjector} from "./services/app-injector.service";
import {UserService} from "./services/user.service";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    UserModule,
    SharedModule,
    NavBarModule,
    ArticleDetailsModule,
    OverviewModule,
    CreateArticleModule,
    PageNotFoundModule,
    ShoppingCartModule,
    BrowserModule,
    AppRoutingModule,


  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule {

  constructor(inject: Injector) {
    AppInjector.setInjector(inject);
  }
}
