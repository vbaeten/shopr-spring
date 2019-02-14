

export class User{

  firstName: string;
  lastName: string;
  userName: string;
  orderLines=[]

  constructor(firstName?: string, lastName?:string, userName?:string,orderLines?:Array) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    if (orderLines) {
      this.orderLines = orderLines;
    }
  }

}
