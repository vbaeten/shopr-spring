import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {UserDetailComponent} from './components/user/user-detail/user-detail.component';
import {UsersComponent} from './components/user/users/users.component';
import {ShopComponent} from './components/shop/shop/shop.component';
import {ExampleComponent} from './components/temp/example/example.component';
import {AddArticlesComponent} from './components/articles/add/add-articles/add-articles.component';
import {FictionDetailComponent} from './components/articles/details/fiction-detail/fiction-detail.component';
import {NonFictionDetailComponent} from './components/articles/details/non-fiction-detail/non-fiction-detail.component';
import {GameDetailComponent} from './components/articles/details/game-detail/game-detail.component';
import {LpDetailComponent} from './components/articles/details/lp-detail/lp-detail.component';
import {ShoppingCartComponent} from './components/order/shopping-cart/shopping-cart.component';

const routes: Routes = [
  {path: '', component: HomeComponent, pathMatch: 'full'},
  {path: 'user', component: UserDetailComponent},
  {path: 'users', component: UsersComponent},
  {path: 'shop', component: ShopComponent},
  {path: 'add', component: AddArticlesComponent},
  {path: 'cart', component: ShoppingCartComponent},
  {path: 'o', component: ExampleComponent},
  {path: 'fiction/:id', component: FictionDetailComponent},
  {path: 'nonfiction/:id', component: NonFictionDetailComponent},
  {path: 'game/:id', component: GameDetailComponent},
  {path: 'lp/:id', component: LpDetailComponent},
  {path: '**', redirectTo: '/'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
