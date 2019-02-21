import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-reactiveform',
  templateUrl: './reactiveform.component.html',
  styleUrls: ['./reactiveform.component.css']
})
export class ReactiveformComponent implements OnInit {

  name = new FormControl('');

  /**Use the constructor of FormControl to set its initial value, which in this case is an empty string.
   * By creating these controls in your component class, you get immediate access to listen for, update,
   * and validate the state of the form input.**/

  constructor() {
  }

  ngOnInit() {
  }

  updateName() {
    this.name.setValue('Nancy');
  }

}
