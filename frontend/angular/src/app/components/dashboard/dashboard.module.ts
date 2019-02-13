import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {DashboardRoutingModule} from './dashboard-routing.module';
import {GamesComponent} from './games/games.component';
import {FictionsComponent} from './fictions/fictions.component';
import {NonFictionsComponent} from './non-fictions/non-fictions.component';
import {LpsComponent} from './lps/lps.component';
import {MaterialModule} from "../../material.module";

@NgModule({
  declarations: [GamesComponent, FictionsComponent, NonFictionsComponent, LpsComponent],
  imports: [
    CommonModule,
    MaterialModule,
    DashboardRoutingModule
  ]
})
export class DashboardModule { }
