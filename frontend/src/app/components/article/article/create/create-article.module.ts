import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SharedModule} from "../../../../modules/shared-module/shared.module";
import {MaterialModule} from "../../../../modules/material-module/material.module";
import {CreateArticleComponent} from "./create-article/create-article.component";
import {CreateFictionComponent} from "./create-fiction/create-fiction.component";
import {CreateGameComponent} from "./create-game/create-game.component";
import {CreateLpComponent} from "./create-lp/create-lp.component";
import {CreateNonFictionComponent} from "./create-non-fiction/create-non-fiction.component";
import {FictionService} from "../../../../services/fiction.service";
import {GameService} from "../../../../services/game.service";
import {LpService} from "../../../../services/lp.service";
import {NonFictionService} from "../../../../services/non-fiction.service";

@NgModule({
  declarations: [
    CreateArticleComponent,
    CreateFictionComponent,
    CreateGameComponent,
    CreateLpComponent,
    CreateNonFictionComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    MaterialModule
  ],
  exports: [
    CreateArticleComponent,
    CreateFictionComponent,
    CreateGameComponent,
    CreateLpComponent,
    CreateNonFictionComponent
  ],
  providers: [
    FictionService,
    GameService,
    LpService,
    NonFictionService,
  ]
})
export class CreateArticleModule {
}
