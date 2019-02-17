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
import {GamesDetailComponent} from "./components/detail-components/games-detail/games-detail.component";
import {LpsDetailComponent} from "./components/detail-components/lps-detail/lps-detail.component";
import {FictionsDetailComponent} from "./components/detail-components/fictions-detail/fictions-detail.component";
import {NonFictionsDetailComponent} from "./components/detail-components/non-fictions-detail/non-fictions-detail.component";
import {SearchComponent} from "./components/search/search.component";
import {ThankYouComponent} from "./components/index/thank-you/thank-you.component";
import {EditGamesComponent} from "./components/edit components/edit-games/edit-games.component";
import {EditLpsComponent} from "./components/edit components/edit-lps/edit-lps.component";
import {EditFictionComponent} from "./components/edit components/edit-fiction/edit-fiction.component";
import {EditNonFictionComponent} from "./components/edit components/edit-non-fiction/edit-non-fiction.component";
import {CartComponent} from "./components/cart/cart.component";
import {FavouritesComponent} from "./components/detail-components/favourites/favourites.component";
import {FavouritesPageComponent} from "./components/index/favourites-page/favourites-page.component";

const routes: Routes = [
  {path: '', component: IndexComponent},
  {path: 'search', component: SearchComponent},
  {path: 'addGame', component:AddGameComponent},
  {path: 'addLp', component:AddLpComponent},
  {path: 'addFiction', component:AddFictionComponent},
  {path: 'addNonFiction', component:AddNonFictionComponent},
  {path: 'loginRegister', component: LoginRegisterComponent},
  {path: 'gamesOverview', component: GamesOverviewComponent},
  {path: 'itemsOverview', component: AllItemsOverviewComponent},
  {path: 'lpsOverview', component: LpsOverviewComponent},
  {path: 'fictionsOverview', component: FictionsOverviewComponent},
  {path: 'nonFictionsOverview', component: NonFictionsOverviewComponent},
  {path: 'gameDetails', component: GamesDetailComponent},
  {path: 'lpDetails', component: LpsDetailComponent},
  {path: 'fictionDetails', component: FictionsDetailComponent},
  {path: 'nonFictionDetails', component: NonFictionsDetailComponent},
  {path: 'thankYou', component: ThankYouComponent},
  {path: 'editGame', component: EditGamesComponent},
  {path: 'editLp', component: EditLpsComponent},
  {path: 'editFiction', component: EditFictionComponent},
  {path: 'editNonFiction', component: EditNonFictionComponent},
  {path: 'cart', component: CartComponent},
  {path: 'favouritesPage', component: FavouritesPageComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {enableTracing:false, useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
