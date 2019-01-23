import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ArticlesOverviewComponent} from "./components/articles-overview/articles-overview.component";
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [


  {path: 'articles', component: ArticlesOverviewComponent}
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes , {enableTracing:false, useHash:true})
  ], exports: [RouterModule]
})
export class AppRoutingModule {
}
