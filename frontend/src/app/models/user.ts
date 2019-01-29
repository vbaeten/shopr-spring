export class User {

  public id: number;
  public name: string;
  public fistName: string;

  constructor( id : number,  name: string, firstName: string) {
    this.id = id;
    this.name = name;
    this.fistName = firstName;
  }
}
