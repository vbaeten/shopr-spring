import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AppComponent} from "./app.component";
import {IndexComponent} from "./components/index/index.component";
import {LoginRegisterComponent} from "./components/login-register/login-register.component";
import {AddGameComponent} from "./components/add-game/add-game.component";
import {AddItemsComponent} from "./components/add-items/add-items.component";

const routes: Routes = [
  {path: 'index', component: IndexComponent},
  {path: 'addItems', component:AddItemsComponent},
  {path: 'loginRegister', component: LoginRegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
