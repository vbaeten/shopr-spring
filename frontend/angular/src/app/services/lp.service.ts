import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Lp} from "../domain/Lp";

@Injectable({
  providedIn: 'root'
})
export class LpService {

  constructor(private httpclient: HttpClient) {}
  createLp(lp: Lp): Observable<Lp>{
    return this.httpclient.post<Lp>("/lp/create", lp);
  }

  getLpGenres(): Observable <string[]> {
    return this.httpclient.get<string[]>("/lp/genres");
}

  updateLp(lp: Lp): Observable<void> {
    return this.httpclient.put<void>('lp/edit', lp);
  }
}
