import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from "@angular/common/http";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/layout/header/header.component';
import { FooterComponent } from './components/layout/footer/footer.component';
import { NavbarComponent } from './components/layout/navbar/navbar.component';
import { UserService} from "./services/user.service";
import { AdminComponent } from './components/admin/admin.component';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/user/register/register.component';
import { AppMaterialModule } from "./modules/app-material/app-material.module";
import { LoginComponent } from './components/user/login/login.component';
import { UsersComponent } from './components/user/users/users.component';
import { LpDetailComponent } from './components/articles/details/lp-detail/lp-detail.component';
import { GameDetailComponent } from './components/articles/details/game-detail/game-detail.component';
import { FictiondetailComponent } from './components/articles/details/game-detail/fictiondetail/fictiondetail.component';
import { UserDetailComponent } from './components/user/user-detail/user-detail.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavbarComponent,
    AdminComponent,
    HomeComponent,
    RegisterComponent,
    LoginComponent,
    UsersComponent,
    LpDetailComponent,
    GameDetailComponent,
    UserDetailComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    AppMaterialModule
  ],
  providers: [
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
