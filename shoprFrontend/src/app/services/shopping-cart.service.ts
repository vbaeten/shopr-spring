import { Injectable } from '@angular/core';
import {User} from "../models/user";
import {Orderline} from "../models/Orderline";

@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {

  key:string='2'

  constructor() { }



  getShoppingCart(): Array<Orderline>{

    return Object.assign(new Array<Orderline>(),JSON.parse(localStorage.getItem(this.key)))
  }
}





