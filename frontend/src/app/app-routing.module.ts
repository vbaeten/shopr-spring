import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RegisterComponent} from "./components/user/register/register.component";
import {NavBarComponent} from "./components/nav-bar/nav-bar.component";
import {UserComponent} from "./components/user/user/user.component";
import {LoginComponent} from "./components/user/login/login.component";
import {ArticleOverviewComponent} from "./components/article/article/overview/articles-overview/article-overview.component";
import {CreateArticleComponent} from "./components/article/article/create/create-article/create-article.component";
import {GameDetailsComponent} from "./components/article/article/details/game-details/game-details.component";
import {LpDetailsComponent} from "./components/article/article/details/lp-details/lp-details.component";
import {FictionDetailsComponent} from "./components/article/article/details/fiction-details/fiction-details.component";
import {NonFictionDetailsComponent} from "./components/article/article/details/non-fiction-details/non-fiction-details.component";
import {ShoppingCartComponent} from "./components/shopping-cart/shopping-cart.component";

const routes: Routes = [
  // {path: '**', component: PageNotFoundComponent},
  {path: '', component: NavBarComponent, outlet: "nav-bar"},
  {path: 'users', component: UserComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent},
  {path: 'articles', component: ArticleOverviewComponent},
  {path: 'article/create-article', component: CreateArticleComponent},
  {path: 'article/game-details/:id', component: GameDetailsComponent},
  {path: 'article/lp-details/:id', component: LpDetailsComponent},
  {path: 'article/fiction-details/:id', component: FictionDetailsComponent},
  {path: 'article/nonFiction-details/:id', component: NonFictionDetailsComponent},
  {path: 'shoppingCart', component: ShoppingCartComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {enableTracing: false, useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
