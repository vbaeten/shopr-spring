import {Component, OnInit} from '@angular/core';
import {UserService} from "../../../services/user.service";
import {User} from "../../../models/user";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Order} from "../../../models/order";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User;
  registerUserForm: FormGroup;


  constructor(private userService: UserService, private formBuilder: FormBuilder, private router: Router) {

  }

  ngOnInit() {
    this.registerUserForm = this.formBuilder.group({
      userName: ['', Validators.required],
      firstName: ['', Validators.required],
      name: ['', Validators.required],
      admin: [false, Validators.required],
    });
  }

  registerUser() {
    this.user = new User(
      this.registerUserForm.value.userName,
      this.registerUserForm.value.firstName,
      this.registerUserForm.value.name,
      this.registerUserForm.value.admin
    );
    this.user.loggedin = true;
    this.userService.registerUser(this.user);
    this.userService.getUsers();
    let currentOrder: Order = JSON.parse(localStorage.getItem('currentOrder'));
    let currentUser: User = JSON.parse(localStorage.getItem('currentUser'));
    if (currentOrder.user === undefined) {
      currentOrder.user = currentUser;
      localStorage.setItem('currentOrder', JSON.stringify(currentOrder))
    }
    this.router.navigate(["/articles/"])
  }


}
