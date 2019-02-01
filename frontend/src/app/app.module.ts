import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './components/user/register/register.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {
  MatCardModule,
  MatCheckboxModule,
  MatFormFieldModule,
  MatInputModule, MatSelectModule,
  MatSnackBarModule, MatToolbarModule
} from '@angular/material';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { LoginComponent } from './components/user/login/login.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { CreateArticleComponent } from './components/article/create-article/create-article.component';
import { UserComponent } from './components/user/user/user.component';
import { UserDetailsComponent } from './components/user/user-details/user-details.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    NavBarComponent,
    CreateArticleComponent,
    UserComponent,
    UserDetailsComponent
  ],
  imports: [
    ReactiveFormsModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatCardModule,
    MatSnackBarModule,
    MatFormFieldModule,
    MatToolbarModule,
    MatCheckboxModule,
    HttpClientModule,
    MatSelectModule
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
