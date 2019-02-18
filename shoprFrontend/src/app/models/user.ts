import {Orderline} from "./Orderline";


export class User{

  firstName: string;
  lastName: string;
  userName: string;
  orderLines:Orderline[]= []
  // favourites:any[]

  constructor(firstName?: string, lastName?:string, userName?:string,orderLines?:any[]) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;

      this.orderLines = orderLines;

    // if(favourites){
    //   this.favourites=favourites
    // }
  }

}
