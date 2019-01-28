import {Component, OnInit} from '@angular/core';

export interface Gamegenre {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-creategame',
  templateUrl: './creategame.component.html',
  styleUrls: ['./creategame.component.css']
})
export class CreategameComponent implements OnInit {
  price: number;
  title: string;
  publisher: string;
  supplierId: string;
  minimumAge: number;
  Gamegenre: string;
  constructor() { }
  gamegenres: Gamegenre[] = [
    {value: 'MMORPG', viewValue: 'MMORPG'},
    {value: 'RPG', viewValue: 'RPG'},
    {value: 'FPS', viewValue: 'FPS'},
    {value: 'RACE', viewValue: 'RACE'},
    {value: 'RTS', viewValue: 'RTS'}
  ];
  ngOnInit() {
  }

}
