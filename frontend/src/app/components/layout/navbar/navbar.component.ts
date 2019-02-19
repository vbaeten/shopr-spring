import {Component, OnDestroy, OnInit} from '@angular/core';
import {User} from '../../../models/user';
import {LoginService} from '../../../services/login.service';
import {Subscription} from 'rxjs';
import {ShoppingCartService} from '../../../services/shopping-cart.service';
import {OrderLine} from '../../../models/order-line';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, OnDestroy {

  currentUser: User = new User();
  orderLines: OrderLine[];
  private userSubscription: Subscription;
  private orderLineAddedSubscription: Subscription;
  dataSource;

  constructor(private loginService: LoginService,
              private cartService: ShoppingCartService) {
  }

  ngOnInit() {
    this.getCurrentUser();
    this.userSubscription = this.loginService.userSubject.subscribe(() => this.getCurrentUser());
    this.orderLineAddedSubscription = this.cartService.orderLineAddedSubject.subscribe( data => {
      this.orderLines.push(data);
      this.orderLines = this.orderLines;
    });
  }

  getCurrentUser() {
    this.loginService.getCurrentUser().then(user => {
      this.currentUser = user;
      this.getOrderLines();
    });
  }

  logout() {
    this.loginService.logout();
  }

  ngOnDestroy(): void {
    this.userSubscription.unsubscribe();
  }


  getOrderLines() {
    this.cartService.findCurrentCartByOrderLinesByUserId(this.currentUser.id).subscribe(
      data => {
        this.orderLines = data;
        this.dataSource = this.orderLines;
      }
    );
  }
}
