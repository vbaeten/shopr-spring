import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Booknonfiction} from "../domain/Booknonfiction";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BooknonfictionService {

  constructor(private httpClient: HttpClient) {
  }

  createBooknonfiction(booknonfiction: Booknonfiction): Observable<Booknonfiction> {
    return this.httpClient.post<Booknonfiction>("/booknonfiction/create", booknonfiction);
  }

  getBooknonfictionGenres(): Observable<string[]> {
    return this.httpClient.get<string[]>("/booknonfiction/genres");
  }
}
