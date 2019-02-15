import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Review} from "../models/review";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Item} from "../models/item";

@Injectable({
  providedIn: 'root'
})
export class ReviewService {


  private classUrl: string = environment.baseApiUrl+'/reviews';

  constructor(private http: HttpClient) {
  }



  getReviewsByItemId(id:number):Observable<Review[]>{

    return this.http.get<Review[]>(this.classUrl+'/'+id)
  }

  addReview(review:Review):Observable<Review>{
    return this.http.post<Review>(this.classUrl,review)
  }

}
