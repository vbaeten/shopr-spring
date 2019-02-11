export class User {
  firstName: string;
  lastName: string;
  userName: string;
  loggedIn: boolean;
  admin: boolean;
  userId?: number;

  constructor(firstName?: string, lastName?: string, userName?: string, loggedIn?: boolean, admin?: boolean, userId?: number) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.loggedIn = loggedIn;
    this.admin = admin;
    this.userId = userId;
  }
}
