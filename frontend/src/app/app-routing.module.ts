import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserComponent} from "./components/user/user.component";

const routes: Routes = [{path:'',component:UserComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes, {enableTracing:false, useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
