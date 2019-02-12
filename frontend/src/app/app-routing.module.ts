import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RegisterComponent} from "./components/user/register/register.component";
import {NavBarComponent} from "./components/nav-bar/nav-bar.component";
import {UserComponent} from "./components/user/user/user.component";
import {LoginComponent} from "./components/user/login/login.component";

const routes: Routes = [
  {path: 'login', component: RegisterComponent, outlet: "register"},
  {path: '', component: NavBarComponent, outlet: "nav-bar"},
  {path: 'user', component: UserComponent},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {enableTracing: false, useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
