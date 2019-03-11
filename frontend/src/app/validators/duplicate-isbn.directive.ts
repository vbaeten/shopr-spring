import {AbstractControl, ValidatorFn} from "@angular/forms";
import {AppInjector} from "../services/app-injector.service";
import {BookService} from "../services/book.service";
import {Book} from "../models/book";

let error = {};

export class ValidateDuplicateIsbn {


  static isDuplicate(currentBookId: any, book?: Book): ValidatorFn {
    const injector = AppInjector.getInjector();
    const bookService = injector.get(BookService);
    return (control: AbstractControl): null => {

      if (book) {
        let currentIsbn = book.isbn;
        bookService.getBookByIsbnEdit(control.value, currentBookId).subscribe(bookByIsbn => {
        }, () => {
          if (currentIsbn == control.value) {
            control.setErrors({isDuplicate: false});
          } else {
            control.setErrors({isDuplicate: true});
          }
        });
      } else {
        if (control.value) {
          bookService.getBookByIsbn(control.value).subscribe(book => {
          }, () => {
            control.setErrors({isDuplicate: true});
          });
        }
      }
      return null;
    };

  }
}
