import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {IndexComponent} from "./components/index/index.component";
import {LoginRegisterComponent} from "./components/login-register/login-register.component";
import {AddGameComponent} from "./components/add-game/add-game.component";
import {AddLpComponent} from "./components/add-lp/add-lp.component";
import {AddFictionComponent} from "./components/add-fiction/add-fiction.component";
import {AddNonFictionComponent} from "./components/add-non-fiction/add-non-fiction.component";
import {AddItemsComponent} from "./components/add-items/add-items.component";

const routes: Routes = [
  {path: 'index', component: IndexComponent},
  {path: 'addGame', component:AddGameComponent},
  {path: 'addLp', component:AddLpComponent},
  {path: 'addFiction', component:AddFictionComponent},
  {path: 'addNonFiction', component:AddNonFictionComponent},
  {path: 'loginRegister', component: LoginRegisterComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {enableTracing:false, useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
