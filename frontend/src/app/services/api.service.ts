import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
};

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private httpClient: HttpClient) {
  }

  public doGet(uri: string, parameters?: Map<string, string>): Observable<any> {
    return this.httpClient.get(`${environment.baseApiUrl}` + uri + this.generateQueryString(parameters));
  }

  public doPost(uri: string, body: Object, parameters?: Map<string, string>) {
    return this.httpClient.post(`${environment.baseApiUrl}` + uri + this.generateQueryString(parameters), body, httpOptions);
  }

  public doPut(uri: string, body: Object, parameters?: Map<string, string>) {
    return this.httpClient.put(`${environment.baseApiUrl}` + uri + this.generateQueryString(parameters), body, httpOptions);
  }

  public doDelete(uri: string) {
    return this.httpClient.delete(`${environment.baseApiUrl}` + uri);
  }

  public generateQueryString(parameters: Map<string, string>): string {
    if (parameters === undefined || parameters === null || parameters.size === 0) {
      return "";
    } else {
      var queryString: string = "?";
      parameters.forEach((value: string, key: string) => {
        queryString += key + "=" + value + "&";
      });
      return queryString;
    }
  }

}
