import {Injectable} from "@angular/core";
import {MatSnackBar} from "@angular/material";
import {ApiService} from "./api.service";
import {NonFiction} from "../models/nonFiction";

@Injectable({
  providedIn: 'root'
})
export class NonFictionService {
  constructor(private notification: MatSnackBar, private apiService: ApiService) {
  }

  public createNonFiction(nonFiction: NonFiction) {
    this.apiService.doPost("/nonFiction", nonFiction).subscribe(response => {
        this.notification.open("New Non fiction book created", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "Non fiction book has not been created, try again! 👎", {duration: 3000});
      })
  };

  public edit(nonFiction: NonFiction) {
    this.apiService.doPut("/nonFiction", nonFiction).subscribe(response => {
        this.notification.open("Non fiction book has been updated", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "Non fiction book has not been updated, try again! 👎", {duration: 3000});
      })
  }

  public getNonFictions(): Promise<NonFiction[]> {
    return this.apiService.doGet("/nonFiction")
      .toPromise()
      .catch(error => NonFictionService.handleError(error))
  }

  private static handleError(error: any): Promise<any> {
    return Promise.reject(error.message | error);
  }
}
