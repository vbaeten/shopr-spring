import {AbstractControl} from "@angular/forms";
import {AppInjector} from "../services/app-injector.service";
import {BookService} from "../services/book.service";


let error = {};

export class ValidateDuplicateIsbn {



  static isDuplicate (control: AbstractControl) {
    if (control.value) {
      let injector = AppInjector.getInjector();
      const bookService = injector.get(BookService);

      bookService.getBookByIsbn(control.value).subscribe
      (book => {}, () => { control.setErrors({isDuplicate: true}); });

    }
    return null;

  }
}
