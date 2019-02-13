import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {GamesComponent} from "./games/games.component";
import {FictionsComponent} from "./fictions/fictions.component";
import {NonFictionsComponent} from "./non-fictions/non-fictions.component";
import {LpsComponent} from "./lps/lps.component";

const routes: Routes = [
  {
    path: 'game',
    component: GamesComponent
  },
  {
    path: 'fiction',
    component: FictionsComponent
  },
  {
    path: 'nonFiciton',
    component: NonFictionsComponent
  },
  {
    path: 'lp',
    component: LpsComponent
  },
  {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
