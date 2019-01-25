import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-add-items',
  templateUrl: './add-items.component.html',
  styleUrls: ['./add-items.component.css']
})
export class AddItemsComponent implements OnInit {

  @Output() newPrice :EventEmitter<number> = new EventEmitter();
  @Output() newTitle :EventEmitter<string> = new EventEmitter();

  price:number;

  title:string;


  constructor() { }

  ngOnInit() {

  }

  onChange(): void {
    this.newPrice.emit(this.price);
    this.newTitle.emit(this.title);
  }





}
