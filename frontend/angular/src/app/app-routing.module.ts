import {NgModule} from '@angular/core';
import {ArticlesOverviewComponent} from "./components/articles-overview/articles-overview.component";
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./components/home/home.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'articles', component: ArticlesOverviewComponent},
  {path: '**', redirectTo: 'home', pathMatch: 'full'}
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes , {enableTracing:false, useHash:true})
  ], exports: [RouterModule]
})
export class AppRoutingModule {
}
