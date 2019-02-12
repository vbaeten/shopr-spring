import {Component, ElementRef, OnInit} from '@angular/core';
import {UserService} from '../../../services/user.service';
import {User} from '../../../models/user';
import {FormBuilder, FormControl, FormGroup, NgForm, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  dataSource;
  user: User;
  users: User[];

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.refresh();
  }

  onSubmit(form: NgForm) {
    this.user = new User();
    this.user.firstName = form.value.firstName;
    this.user.name = form.value.name;
    this.userService.registerUser(this.user).subscribe(data => this.refresh);
  }

  refresh() {
    this.userService.getUsers().subscribe(data => {
      this.users = data;
      this.dataSource = this.users;
    });
  }
}

