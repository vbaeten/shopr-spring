import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RegisterComponent} from "./components/auth/register/register.component";
import {LoginComponent} from "./components/auth/login/login.component";
import {ProductListComponent} from "./components/product-list/product-list.component";
import {AuthGuard} from "./services/auth-guard.service";

const routes: Routes = [
  {path: 'products', component: ProductListComponent, canActivate: [AuthGuard] },
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent},
  { path: '', redirectTo: '/products', pathMatch: 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
