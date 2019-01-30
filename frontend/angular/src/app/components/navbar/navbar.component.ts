import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  private _authenticated: boolean;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this._authenticated = this.authService.isAuthenticated(undefined, undefined);
    console.log('is authenticated: ' + this._authenticated)
  }


  get authenticated(): boolean {
    return this._authenticated;
  }
}
