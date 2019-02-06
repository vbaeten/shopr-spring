import {Component, ElementRef, OnInit} from '@angular/core';
import {UserService} from '../../../services/user.service';
import {User} from '../../../models/user';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User;
  firstName;
  name;

  constructor(userService: UserService) {
  }

  ngOnInit() {
    // // this.registerForm = this.formBuilder.group({
    //   firstName: ['', Validators.required],
    //   name: ['', Validators.required]
    // }
    // );
  }



  onSubmit(form: ElementRef) {
    console.log(form);
  }
}

