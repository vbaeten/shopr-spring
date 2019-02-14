

export class User{

  firstName: string;
  lastName: string;
  userName: string;
  orderLines: Array

  constructor(firstName?: string, lastName?:string, userName?:string,orderLines?:Array) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.orderLines=orderLines;
  }

}
