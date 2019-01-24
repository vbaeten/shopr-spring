import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {IndexComponent} from "./components/index/index.component";
import {LoginRegisterComponent} from "./components/login-register/login-register.component";
import {AddItemsComponent} from "./components/add-items/add-items.component";

const routes: Routes = [
  {path: '', component: IndexComponent},
  {path: 'addItems', component:AddItemsComponent},
  {path: 'loginRegister', component: LoginRegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {enableTracing:false, useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
