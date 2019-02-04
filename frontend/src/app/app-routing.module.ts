import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { UserDetailComponent } from './components/user/user-detail/user-detail.component';
import {UsersComponent} from './components/user/users/users.component';
import {ShopComponent} from './components/shop/shop/shop.component';
import {ExampleComponent} from './components/temp/example/example.component';
import {AddArticlesComponent} from './components/articles/add/add-articles/add-articles.component';

const routes: Routes = [
  {path: '', component: HomeComponent, pathMatch: 'full'},
  {path: 'user', component: UserDetailComponent},
  {path: 'users', component: UsersComponent},
  {path: 'shop', component: ShopComponent},
  {path: 'add', component: AddArticlesComponent},
  {path: 'o', component: ExampleComponent},
  {path: '**', redirectTo: '/'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
