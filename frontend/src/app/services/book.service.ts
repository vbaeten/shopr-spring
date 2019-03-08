import {Injectable} from "@angular/core";
import {MatSnackBar} from "@angular/material";
import {ApiService} from "./api.service";


@Injectable({
  providedIn: 'root'
})
export class BookService {
  constructor(private notification: MatSnackBar, private apiService: ApiService) {
  }

  public getBookByIsbn(isbn: string) {
    return this.apiService.doGet("/book/" + isbn);
  }

}
