import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from "./components/home/home.component";
import { UserDetailComponent } from "./components/user/user-detail/user-detail.component";
import {UsersComponent} from "./components/user/users/users.component";
import {ShopComponent} from "./components/shop/shop/shop.component";

const routes: Routes = [
  {path: '', component: HomeComponent, pathMatch: 'full'},
  {path: 'user', component: UserDetailComponent},
  {path: 'users',component: UsersComponent},
  {path: 'shop', component: ShopComponent},
  {path: '**', redirectTo: '/'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
