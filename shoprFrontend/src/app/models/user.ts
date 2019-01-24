

export class User{

  firstName: string;
  lastName: string;
  userName: string;

  constructor(firstName?: string, lastName?:string, userName?:string) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
  }

}
