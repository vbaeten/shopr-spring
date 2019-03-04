import {Component, OnInit} from '@angular/core';
import {UserService} from '../../../../services/user.service';
import {User} from '../../../../models/user';
import {FormControl, FormGroup, NgForm} from '@angular/forms';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;

  constructor(private userService: UserService,
              private snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.registerForm = new FormGroup({
      firstName: new FormControl(''),
      name: new FormControl('')
    });
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  onSubmit() {
    const user = new User();
    user.firstName = this.registerForm.value.firstName;
    user.name = this.registerForm.value.name;
    this.userService.registerUser(user);
  }
}

