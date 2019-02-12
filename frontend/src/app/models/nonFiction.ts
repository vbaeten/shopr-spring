import {Book} from "./book";
import {NonFictionSubject} from "./non-fiction-subject";

export class NonFiction extends Book {

  public nonFictionSubject: NonFictionSubject;


  constructor(nonFictionSubject?: NonFictionSubject) {
    super();
    this.nonFictionSubject = nonFictionSubject;
  }
}
