export class User {
  constructor(public firstName: string,
              public lastName: string,
              public userName: string,
              public loggedIn: boolean,
              public admin: boolean,
              public userId?: number) {
  }
}
