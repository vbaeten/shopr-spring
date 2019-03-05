import {Injectable} from "@angular/core";
import {MatSnackBar} from "@angular/material";
import {ApiService} from "./api.service";
import {NonFiction} from "../models/nonFiction";
import {Observable} from "rxjs";

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

  public edit(id: number, nonFiction: NonFiction) {
    this.apiService.doPut("/nonFiction/" + id, nonFiction).subscribe(response => {
        this.notification.open("Non fiction book has been updated", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "Non fiction book has not been updated, try again! 👎", {duration: 3000});
      })
  }

  public getNonFictions() {
    return this.apiService.doGet("/nonFiction")
  }

  public deleteNonFiction(id: number) {
    return this.apiService.doDelete("/nonFiction/" + id)
  }

  public getNonFictionById(id: number): Observable<NonFiction> {
    return this.apiService.doGet("/nonFiction/" + id);
  }
}
