import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RegisterComponent} from "./register/register.component";
import {LoginComponent} from "./login/login.component";
import {DashboardComponent} from "../dashboard/dashboard.component";
import {AdminGuard} from "../../services/admin.guard";
import {ProductListComponent} from "../products/product-list/product-list.component";

const routes: Routes = [
  {path: '', component: ProductListComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent},
  {path: 'dashboard', component: DashboardComponent, canActivate: [AdminGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash:true})],
  exports: [RouterModule]
})
export class AuthRoutingModule { }
