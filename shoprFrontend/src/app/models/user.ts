import {Orderline} from "./Orderline";


export class User {

  firstName: string;
  lastName: string;
  userName: string;
  orderLines: Orderline[] = []
  // favourites: Item[]=[]

  constructor(firstName?: string, lastName?: string, userName?: string, orderLines?: any[]) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.orderLines = orderLines;
    // this.favourites = favourites
  }

}
