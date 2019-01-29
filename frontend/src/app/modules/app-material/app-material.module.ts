import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  MatButtonModule,
  MatCardModule,
  MatIconModule,
  MatTableModule,
  MatToolbarModule,
  MatMenuModule
} from "@angular/material";
import {FlexLayoutModule} from "@angular/flex-layout";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatCardModule,
    MatToolbarModule,
    FlexLayoutModule,
    MatTableModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatMenuModule,
    MatIconModule,
    NgbModule
  ],
  exports: [
    MatCardModule,
    MatToolbarModule,
    FlexLayoutModule,
    MatTableModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatMenuModule,
    MatIconModule,
    NgbModule
  ]
})

export class AppMaterialModule { }
