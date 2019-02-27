import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {
  MatBadgeModule,
  MatButtonModule,
  MatCardModule,
  MatExpansionModule,
  MatFormFieldModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatMenuModule,
  MatSelectModule,
  MatSnackBarModule,
  MatSortModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule
} from '@angular/material';
import {FlexLayoutModule} from '@angular/flex-layout';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {ReactiveFormsModule} from '@angular/forms';

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
    NgbModule,
    MatSelectModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    MatSortModule,
    MatSnackBarModule,
    MatExpansionModule,
    MatTabsModule,
    MatBadgeModule,
    MatGridListModule
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
    NgbModule,
    MatSelectModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    MatSortModule,
    MatSnackBarModule,
    MatExpansionModule,
    MatTabsModule,
    MatBadgeModule,
    MatGridListModule
  ]
})

export class AppMaterialModule { }
