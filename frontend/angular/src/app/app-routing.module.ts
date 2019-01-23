import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ArticlesOverviewComponent} from "./components/articles-overview/articles-overview.component";

const routes: Routes = [{path: 'article', component:ArticlesOverviewComponent, pathMatch:'full'}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
