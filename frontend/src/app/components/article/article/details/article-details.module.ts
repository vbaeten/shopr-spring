import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SharedModule} from "../../../../modules/shared-module/shared.module";
import {MaterialModule} from "../../../../modules/material-module/material.module";
import {FictionDetailsComponent} from "./fiction-details/fiction-details.component";
import {GameDetailsComponent} from "./game-details/game-details.component";
import {LpDetailsComponent} from "./lp-details/lp-details.component";
import {NonFictionDetailsComponent} from "./non-fiction-details/non-fiction-details.component";
import {ArticleService} from "../../../../services/article.service";
import {OrderLineService} from "../../../../services/order-line.service";
import {OrderService} from "../../../../services/order.service";

@NgModule({
  declarations: [
    FictionDetailsComponent,
    GameDetailsComponent,
    LpDetailsComponent,
    NonFictionDetailsComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    MaterialModule
  ],
  exports: [
    FictionDetailsComponent,
    GameDetailsComponent,
    LpDetailsComponent,
    NonFictionDetailsComponent
  ],
  providers: [
    ArticleService,
    OrderLineService,
    OrderService,
  ]
})
export class ArticleDetailsModule {
}
