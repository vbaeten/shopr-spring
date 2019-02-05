export class User {

  constructor(
    public username: string, public firstname: string, public lastname: string,
    public password: string,
    public id?: number) {
    this.username = username;
    this.firstname = firstname;
    this.lastname = lastname;
    this.password = password;
    this.id = id;
  }
}
