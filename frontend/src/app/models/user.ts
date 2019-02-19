export class User {

  constructor(public userName?: string,
              public firstName?: string,
              public name?: string,
              public admin?: boolean,
              public loggedin?: boolean,
              public id?: number,
  ) {
    this.userName = userName;
    this.firstName = firstName;
    this.name = name;
    this.admin = admin;
    this.loggedin = loggedin;
    this.id = id;
  }

}
