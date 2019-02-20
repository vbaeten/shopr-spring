import {User} from './user';

export class Cart {

  public id: number;
  public user: User;
  public userId: number;


  constructor(id?: number, user?: User, userId?: number) {
    this.id = id;
    this.user = user;
    this.userId = userId;
  }
}
