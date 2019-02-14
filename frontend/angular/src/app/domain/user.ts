export class User {
  firstName: string;
  lastName: string;
  userName: string;
  admin: boolean;
  userId?: number;

  constructor(firstName?: string, lastName?: string, userName?: string, admin?: boolean, userId?: number) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.admin = admin;
    this.userId = userId;
  }
}
