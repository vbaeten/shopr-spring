import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private httpClient: HttpClient) {
  }

  public doGet(uri: string, parameters?: Map<string, string>): Observable<any> {
    return this.httpClient.get(uri, {params: this.appendParameters(parameters)});
  }

  public doPost(uri: string, body: Object, parameters?: Map<string, string>) {
    return this.httpClient.post<any>(uri, body, {params: this.appendParameters(parameters)});
  }

  public doPut(uri: string, body: Object, parameters?: Map<string, string>) {
    return this.httpClient.put<any>(uri, body, {params: this.appendParameters(parameters)});
  }

  public doDelete(uri: string) {
    return this.httpClient.delete(uri);
  }

  public appendParameters(parameters: Map<string, string>) {
    let params = new HttpParams();
    if (parameters !== undefined && parameters.size > 0) {
      parameters.forEach((value, key) => {
        params = params.append(key, value);
      });

    }
    return params;
  }

}
