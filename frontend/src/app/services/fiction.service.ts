import {Injectable} from "@angular/core";
import {MatSnackBar} from "@angular/material";
import {ApiService} from "./api.service";
import {Fiction} from "../models/fiction";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FictionService {
  constructor(private notification: MatSnackBar, private apiService: ApiService) {
  }

  public createFiction(fiction: Fiction) {
    this.apiService.doPost("/fiction", fiction).subscribe(response => {
        this.notification.open("New fiction book created", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "Fiction book has not been created, try again! 👎", {duration: 3000});
      })
  };

  public edit(fiction: Fiction) {
    this.apiService.doPut("/fiction", fiction).subscribe(response => {
        this.notification.open("Fiction book has been updated", "👍", {duration: 3000});
      },
      err => {
        this.notification.open("Something went wrong", "Fiction book has not been updated, try again! 👎", {duration: 3000});
      })
  }

  public getFictions(): Observable<Fiction[]> {
    return this.apiService.doGet("/fiction")
  }

  public deleteFiction(id: number) {
    return this.apiService.doDelete("/fiction/" + id)
  }

  public getFictionById(id: number): Observable<Fiction> {
    return this.apiService.doGet("/fiction/" + id);
  }
}
