import {Component, OnInit} from '@angular/core';
import {UserService} from "../../../services/user.service";
import {User} from "../../../models/user";
import {FormBuilder} from "@angular/forms";
import {OrderService} from "../../../services/order.service";
import {Order} from "../../../models/order";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  selectedUser: User;
  users: User[];

  constructor(private userService: UserService, private formBuilder: FormBuilder, private orderService: OrderService, private router: Router) {
  }

  ngOnInit() {
    this.getAllUsers();
  }

  login() {
      this.userService.setCurrentUser(this.selectedUser);
      let currentOrder: Order = JSON.parse(localStorage.getItem('currentOrder'));
      let currentUser: User = JSON.parse(localStorage.getItem('currentUser'));
      if (currentOrder.user === undefined) {
        currentOrder.user = currentUser;
        localStorage.setItem('currentOrder', JSON.stringify(currentOrder))
      }
      this.router.navigate(["/articles/"])
  }

  getAllUsers (){
    this.userService.getUsers().subscribe(data => {
      this.users = data;
    })
  }

}
