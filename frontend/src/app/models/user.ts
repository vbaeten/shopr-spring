export class User {

  constructor(public firstName: string,
              public name: string,
              // public isAdmin?: boolean,
              // public isLoggedIn?: boolean,
              public id?: number) {
    this.firstName = firstName;
    this.name = name;
    // this.isAdmin = isAdmin;
    // this.isLoggedIn = true;
    this.id=id;
  }

}
