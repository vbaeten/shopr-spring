import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegisterComponent} from "./components/user/register/register.component";

const routes: Routes = [{path:'',component:RegisterComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes, {enableTracing:false, useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
