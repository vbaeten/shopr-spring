import { Injectable } from '@angular/core';
import {ApiService} from "./api.service";
import {Observable} from "rxjs";
import {Fiction} from "../models/fiction";

@Injectable({
  providedIn: 'root'
})
export class FictionService {

  constructor(
    private apiService: ApiService) {
  }

  getFictionBooks(): Observable<Fiction[]>{
    return this.apiService.doGet('/fiction/list');
  }
}
