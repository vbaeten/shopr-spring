import {NgModule} from '@angular/core';
import {ArticlesOverviewComponent} from "./components/articles-overview/articles-overview.component";
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./components/home/home.component";
import {CreateComponent} from "./components/create/create.component";
import {CreatelpComponent} from "./components/createlp/createlp.component";
import {CreategameComponent} from "./components/creategame/creategame.component";
import {CreatebookfictionComponent} from "./components/createbookfiction/createbookfiction.component";
import {CreatebooknonfictionComponent} from "./components/createbooknonfiction/createbooknonfiction.component";
import {DetailComponent} from "./components/detail/detail.component";
import {RegisterComponent} from "./components/register/register.component";
import {SigninComponent} from "./components/signin/signin.component";
import {AdminGuard} from "./guard/admin.guard";
import {EditbookfictionComponent} from "./components/editbookfiction/editbookfiction.component";
import {EditbooknonfictionComponent} from "./components/editbooknonfiction/editbooknonfiction.component";
import {EditgameComponent} from "./components/editgame/editgame.component";
import {EditlpComponent} from "./components/editlp/editlp.component";
import {ShoppingcartComponent} from "./components/shoppingcart/shoppingcart.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'createlp', component: CreatelpComponent, canActivate: [AdminGuard]},
  {path: 'creategame', component: CreategameComponent, canActivate: [AdminGuard]},
  {path: 'createbookfiction', component: CreatebookfictionComponent, canActivate: [AdminGuard]},
  {path: 'createbooknonfiction', component: CreatebooknonfictionComponent, canActivate: [AdminGuard]},
  {path: 'editbookfiction/:articleId', component: EditbookfictionComponent /*, canActivate: [AdminGuard]*/},
  {path: 'editbooknonfiction/:articleId', component: EditbooknonfictionComponent /*, canActivate: [AdminGuard]*/},
  {path: 'editgame/:articleId', component: EditgameComponent /*, canActivate: [AdminGuard]*/},
  {path: 'editlp/:articleId', component: EditlpComponent /*, canActivate: [AdminGuard]*/},
  {path: 'articles', component: ArticlesOverviewComponent},
  {path: 'articles/detail/:articleId', component: DetailComponent},
  {path: 'create', component: CreateComponent, canActivate: [AdminGuard]},
  {path: 'register', component: RegisterComponent},
  {path: 'signin', component: SigninComponent},
  {path: 'shoppingcart', component: ShoppingcartComponent},
  {path: '**', redirectTo: 'home'}
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes , {enableTracing:false, useHash:true})
  ], exports: [RouterModule]
})
export class AppRoutingModule {
}
