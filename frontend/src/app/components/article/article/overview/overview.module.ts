import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SharedModule} from "../../../../modules/shared-module/shared.module";
import {MaterialModule} from "../../../../modules/material-module/material.module";
import {ArticleOverviewComponent} from "./articles-overview/article-overview.component";
import {FictionOverviewComponent} from "./fiction-overview/fiction-overview.component";
import {GameOverviewComponent} from "./game-overview/game-overview.component";
import {LpOverviewComponent} from "./lp-overview/lp-overview.component";
import {NonFictionOverviewComponent} from "./non-fiction-overview/non-fiction-overview.component";
import {ArticleService} from "../../../../services/article.service";
import {FictionService} from "../../../../services/fiction.service";
import {GameService} from "../../../../services/game.service";
import {LpService} from "../../../../services/lp.service";
import {NonFictionService} from "../../../../services/non-fiction.service";
import {OverviewComponent} from './overview.component';

@NgModule({
  declarations: [
    ArticleOverviewComponent,
    FictionOverviewComponent,
    GameOverviewComponent,
    LpOverviewComponent,
    NonFictionOverviewComponent,
    OverviewComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    MaterialModule
  ],
  exports: [
    ArticleOverviewComponent,
    FictionOverviewComponent,
    GameOverviewComponent,
    LpOverviewComponent,
    NonFictionOverviewComponent
  ],
  providers: [
    ArticleService,
    FictionService,
    GameService,
    LpService,
    NonFictionService
  ]
})
export class OverviewModule {
}
