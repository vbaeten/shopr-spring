import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RegisterComponent} from "./components/auth/register/register.component";
import {LoginComponent} from "./components/auth/login/login.component";
import {ProductListComponent} from "./components/product-list/product-list.component";
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {AdminGuard} from "./services/admin.guard";

const routes: Routes = [
  {path: 'products', component: ProductListComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent},
  {path: 'dashboard', component: DashboardComponent, canActivate: [AdminGuard]},
  { path: '', redirectTo: '/products', pathMatch: 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
