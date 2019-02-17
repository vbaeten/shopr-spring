

export class User{

  firstName: string;
  lastName: string;
  userName: string;
  orderLines:any[]
  favourites:any[]

  constructor(firstName?: string, lastName?:string, userName?:string,orderLines?:any[],favourites?:any[]) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    if (orderLines) {
      this.orderLines = orderLines;
    }
    this.favourites=favourites
  }

}
