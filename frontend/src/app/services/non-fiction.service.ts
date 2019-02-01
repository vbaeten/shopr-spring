import { Injectable } from '@angular/core';
import {ApiService} from "./api.service";
import {Observable} from "rxjs";
import {Fiction} from "../models/fiction";

@Injectable({
  providedIn: 'root'
})
export class NonFictionService {

  constructor(
    private apiService: ApiService) {
  }

  getNonFictionBooks(): Observable<Fiction[]>{
    return this.apiService.doGet('/nonfiction/list');
  }

}
