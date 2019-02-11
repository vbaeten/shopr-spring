import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Bookfiction} from "../domain/bookfiction";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BookfictionService {
  constructor(private httpClient: HttpClient) {
  }

  createBookfiction(bookfiction: Bookfiction): Observable<Bookfiction> {
    return this.httpClient.post<Bookfiction>("/bookfiction/create", bookfiction);
  }

  getBookfictionGenres(): Observable<string[]> {
    return this.httpClient.get<string[]>("/bookfiction/genres");
  }

  updateBookfiction(bookfiction: Bookfiction): Observable<void> {
    return this.httpClient.put<void>('bookfiction/edit', bookfiction);
  }
}
