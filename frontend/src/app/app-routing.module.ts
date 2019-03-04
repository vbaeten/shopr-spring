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
import {GameOverviewComponent} from "./components/article/article/overview/game-overview/game-overview.component";
import {LpOverviewComponent} from "./components/article/article/overview/lp-overview/lp-overview.component";
import {FictionOverviewComponent} from "./components/article/article/overview/fiction-overview/fiction-overview.component";
import {NonFictionOverviewComponent} from "./components/article/article/overview/non-fiction-overview/non-fiction-overview.component";
import {OverviewComponent} from "./components/article/article/overview/overview.component";
import {CreateGameComponent} from "./components/article/article/create/create-game/create-game.component";
import {CreateLpComponent} from "./components/article/article/create/create-lp/create-lp.component";
import {CreateFictionComponent} from "./components/article/article/create/create-fiction/create-fiction.component";
import {CreateNonFictionComponent} from "./components/article/article/create/create-non-fiction/create-non-fiction.component";

const routes: Routes = [
  // {path: '**', component: PageNotFoundComponent},
  {path: '', component: NavBarComponent, outlet: "nav-bar"},
  {path: 'users', component: UserComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent},
  {path: 'shop', component: OverviewComponent},
  {path: 'articles', component: ArticleOverviewComponent},
  {path: 'games', component: GameOverviewComponent},
  {path: 'lps', component: LpOverviewComponent},
  {path: 'fictions', component: FictionOverviewComponent},
  {path: 'nonFictions', component: NonFictionOverviewComponent},
  {path: 'article/create-article', component: CreateArticleComponent},
  {path: 'article/edit-game/:id', component: CreateGameComponent},
  {path: 'article/edit-lp/:id', component: CreateLpComponent},
  {path: 'article/edit-fiction/:id', component: CreateFictionComponent},
  {path: 'article/edit-nonFiction/:id', component: CreateNonFictionComponent},
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
