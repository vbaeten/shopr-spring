import { Injectable } from '@angular/core';
import {ApiService} from "./api.service";
import {Observable} from "rxjs";
import {Fiction} from "../models/fiction";

@Injectable({
  providedIn: 'root'
})
export class LpService {

  constructor(
    private apiService: ApiService) {
  }

  getLps(): Observable<Fiction[]>{
    return this.apiService.doGet('/lp/list');
  }

}
