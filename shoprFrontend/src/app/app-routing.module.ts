import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {IndexComponent} from "./components/index/index.component";
import {LoginRegisterComponent} from "./components/login-register/login-register.component";
import {AddGameComponent} from "./components/add-game/add-game.component";
import {AddLpComponent} from "./components/add-lp/add-lp.component";
import {AddFictionComponent} from "./components/add-fiction/add-fiction.component";
import {AddNonFictionComponent} from "./components/add-non-fiction/add-non-fiction.component";
import {GamesOverviewComponent} from "./components/overview/games-overview/games-overview.component";
import {AllItemsOverviewComponent} from "./components/overview/all-items-overview/all-items-overview.component";
import {LpsOverviewComponent} from "./components/overview/lps-overview/lps-overview.component";
import {FictionsOverviewComponent} from "./components/overview/fictions-overview/fictions-overview.component";
import {NonFictionsOverviewComponent} from "./components/overview/non-fictions-overview/non-fictions-overview.component";

const routes: Routes = [
  {path: '', component: IndexComponent},
  {path: 'addGame', component:AddGameComponent},
  {path: 'addLp', component:AddLpComponent},
  {path: 'addFiction', component:AddFictionComponent},
  {path: 'addNonFiction', component:AddNonFictionComponent},
  {path: 'loginRegister', component: LoginRegisterComponent},
  {path: 'gamesOverview', component: GamesOverviewComponent},
  {path: 'itemsOverview', component: AllItemsOverviewComponent},
  {path: 'lpsOverview', component: LpsOverviewComponent},
  {path: 'fictionsOverview', component: FictionsOverviewComponent},
  {path: 'nonFictionsOverview', component: NonFictionsOverviewComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {enableTracing:false, useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
